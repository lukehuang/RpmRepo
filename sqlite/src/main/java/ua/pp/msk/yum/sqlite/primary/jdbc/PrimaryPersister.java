/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary.jdbc;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.sqlite.common.Conflicts;
import ua.pp.msk.yum.sqlite.common.Enhances;
import ua.pp.msk.yum.sqlite.common.Files;
import ua.pp.msk.yum.sqlite.common.Obsoletes;
import ua.pp.msk.yum.sqlite.common.Persister;
import ua.pp.msk.yum.sqlite.common.Provides;
import ua.pp.msk.yum.sqlite.common.RPM;
import ua.pp.msk.yum.sqlite.common.Recommends;
import ua.pp.msk.yum.sqlite.common.Requires;
import ua.pp.msk.yum.sqlite.common.Suggests;
import ua.pp.msk.yum.sqlite.common.Supplements;
import ua.pp.msk.yum.sqlite.common.exceptions.PersistException;
import ua.pp.msk.yum.sqlite.primary.exceptions.ClosingException;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class PrimaryPersister implements Persister {

    private static final String PACKAGES_TABLE = "packages";
    private static final String FILES_TABLE = "files";
    private static final String CONFLICTS_TABLE = "conflicts";
    private static final String REQUIRES_TABLE = "requires";
    private static final String PROVIDES_TABLE = "provides";
    private static final String OBSOLETES_TABLE = "obsoletes";
    private static final String SUGGESTS_TABLE = "suggests";
    private static final String ENHANCES_TABLE = "enhances";
    private static final String RECOMMENDS_TABLE = "recommends";
    private static final String SUPPLEMENTS_TABLE = "supplements";

    public final static String persistPakages = "INSERT INTO " + PACKAGES_TABLE
            + "(   pkgId ,  name ,  arch ,  version ,  epoch ,  release ,  summary ,  description ,  url ,  time_file ,  time_build ,  rpm_license ,  rpm_vendor ,  rpm_group ,  rpm_buildhost ,  rpm_sourcerpm ,  rpm_header_start ,  rpm_header_end ,  rpm_packager ,  size_package ,  size_installed ,  size_archive ,  location_href ,  location_base ,  checksum_type ) "
            + "VALUES ( ? ,  ? ,  ? ,  ? , ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? , ? ,  ? ,  ? , ? ,  ? ,  ? , ? ,  ? ,  ? ,  ? ,  ?)";
    public final static String persistFiles = "INSERT INTO " + FILES_TABLE + "(name, type, pkgKey) VALUES (? ,?, ?)";
    public final static String getLastPackageKey = "SELECT pkgKey FROM " + PACKAGES_TABLE + " ORDER BY  pkgKey  DESC  LIMIT 1";
    public final static String persistConflicts = "INSERT INTO " + CONFLICTS_TABLE + "(name, flags,  epoch,  version ,  release , pkgKey) VALUES (? ,?, ?, ?, ?, ?)";
    public final static String persistRequires = "INSERT INTO " + REQUIRES_TABLE + "( name ,  flags ,  epoch ,  version ,  release ,  pkgKey , pre) VALUES (? ,?, ?, ?, ?, ?, ?)";
    public final static String persistProvides = "INSERT INTO " + PROVIDES_TABLE + "(name, flags,  epoch,  version ,  release , pkgKey) VALUES (? ,?, ?, ?, ?, ?)";
    public final static String persistObsoletes = "INSERT INTO " + OBSOLETES_TABLE + "(name, flags,  epoch,  version ,  release , pkgKey) VALUES (? ,?, ?, ?, ?, ?)";
    public final static String persistSuggests = "INSERT INTO " + SUGGESTS_TABLE + "(name, flags,  epoch,  version ,  release , pkgKey) VALUES (? ,?, ?, ?, ?, ?)";
    public final static String persistEnhances = "INSERT INTO " + ENHANCES_TABLE + "(name, flags,  epoch,  version ,  release , pkgKey) VALUES (? ,?, ?, ?, ?, ?)";
    public final static String persistRecommends = "INSERT INTO " + RECOMMENDS_TABLE + "(name, flags,  epoch,  version ,  release , pkgKey) VALUES (? ,?, ?, ?, ?, ?)";
    public final static String persistSuppelemnts = "INSERT INTO " + SUPPLEMENTS_TABLE + "(name, flags,  epoch,  version ,  release , pkgKey) VALUES (? ,?, ?, ?, ?, ?)";

    private PreparedStatement packagesStmt;
    private PreparedStatement filesStmt;
    private PreparedStatement lastKey;
    private PreparedStatement conflictsStmt;
    private PreparedStatement requiresStmt;
    private PreparedStatement providesStmt;
    private PreparedStatement obsoletesStmt;
    private PreparedStatement suggestsStmt;
    private PreparedStatement enhancesStmt;
    private PreparedStatement recommendsStmt;
    private PreparedStatement supplementsStmt;

    private Connection dbCon;

    private String dbUrl;
    private String username;
    private String password;

    public PrimaryPersister(String url, String username, String password) {

        this.dbUrl= url;
        this.username = username;
        this.password = password;
        init();
    }
    public PrimaryPersister(Path dbPath, String username, String password) {

        this.dbUrl= "jdbc:sqlite:"+dbPath.toString();
        this.username = username;
        this.password = password;
        init();
    }

    public PrimaryPersister() {
    }

    public void setDbPath(Path dbPath){
        setDbUrl("jdbc:sqlite:"+dbPath.toString());
    }
    
    @Override
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    @Override
    public String getDbUrl() {
        return dbUrl;
    }

    

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Connection getDbCon() {
        return dbCon;
    }
    
    

    private void init() {
        InitDb idb = new InitDb(dbUrl, username, password);
        idb.run();
        dbCon = idb.getConnection();
        try {
            lastKey = dbCon.prepareStatement(getLastPackageKey);
            packagesStmt = dbCon.prepareStatement(persistPakages);
            filesStmt = dbCon.prepareStatement(persistFiles);
            conflictsStmt = dbCon.prepareStatement(persistConflicts);
            requiresStmt = dbCon.prepareStatement(persistRequires);
            obsoletesStmt = dbCon.prepareStatement(persistObsoletes);
            enhancesStmt = dbCon.prepareStatement(persistEnhances);
            suggestsStmt = dbCon.prepareStatement(persistSuggests);
            recommendsStmt = dbCon.prepareStatement(persistRecommends);
            supplementsStmt = dbCon.prepareStatement(persistSuppelemnts);

        } catch (SQLException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot prepare statement " + ex.getMessage(), ex);
        }
    }

    public int getLastPkgKey() {
        int qty = 0;
        try {
            ResultSet lastKeyResultSet = lastKey.executeQuery();
            qty = lastKeyResultSet.last() ? lastKeyResultSet.getInt(1) : 0;

        } catch (SQLException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot prepare statement " + ex.getMessage(), ex);
        }
        return qty;
    }

    @Override
    public void persist(RPM rpm) throws PersistException {
        Iterator<Files> filesIterator = rpm.getFilesCollection().iterator();
        Iterator<Conflicts> conflictsIterator = rpm.getConflictsCollection().iterator();
        Iterator<Requires> requiresIterator = rpm.getRequiresCollection().iterator();
        Iterator<Provides> providesIterator = rpm.getProvidesCollection().iterator();
        Iterator<Obsoletes> obsoletesIterator = rpm.getObsoletesCollection().iterator();
        Iterator<Suggests> suggestsIterator = rpm.getSuggestsCollection().iterator();
        Iterator<Enhances> enhancesIterator = rpm.getEnhancesCollection().iterator();
        Iterator<Recommends> recommendsIterator = rpm.getRecommendsCollection().iterator();
        Iterator<Supplements> supplementsIterator = rpm.getSupplementsCollection().iterator();

        int lk = getLastPkgKey() + 1;
        try {

            dbCon.setAutoCommit(false);
            packagesStmt.setString(1, rpm.getPkgId());
            packagesStmt.setString(2, rpm.getName());
            packagesStmt.setString(3, rpm.getArch());
            packagesStmt.setString(4, rpm.getVersion());
            packagesStmt.setString(5, rpm.getEpoch());
            packagesStmt.setString(6, rpm.getRelease());
            packagesStmt.setString(7, rpm.getSummary());
            packagesStmt.setString(8, rpm.getDescription());
            packagesStmt.setString(9, rpm.getUrl());
            packagesStmt.setInt(10, rpm.getTimeFile());
            packagesStmt.setInt(11, rpm.getTimeBuild());
            packagesStmt.setString(12, rpm.getRpmLicense());
            packagesStmt.setString(13, rpm.getRpmVendor());
            packagesStmt.setString(14, rpm.getRpmGroup());
            packagesStmt.setString(15, rpm.getRpmBuildhost());
            packagesStmt.setString(16, rpm.getRpmSourcerpm());
            packagesStmt.setInt(17, rpm.getRpmHeaderStart());
            packagesStmt.setInt(18, rpm.getRpmHeaderEnd());
            packagesStmt.setString(19, rpm.getRpmPackager());
            packagesStmt.setInt(20, rpm.getSizePackage());
            packagesStmt.setInt(21, rpm.getSizeInstalled());
            packagesStmt.setInt(22, rpm.getSizeArchive());
            packagesStmt.setString(23, rpm.getLocationHref());
            packagesStmt.setString(24, rpm.getLocationBase());
            packagesStmt.setString(26, rpm.getChecksumType());

            packagesStmt.executeUpdate();

            if (filesIterator.hasNext()) {
                while (filesIterator.hasNext()) {
                    Files nextFile = filesIterator.next();
                    filesStmt.setString(1, nextFile.getName());
                    filesStmt.setString(2, nextFile.getType());
                    filesStmt.setInt(3, lk);
                }
                filesStmt.executeUpdate();
            }

            if (conflictsIterator.hasNext()) {
                while (conflictsIterator.hasNext()) {
                    Conflicts nextConflict = conflictsIterator.next();
                    conflictsStmt.setString(1, nextConflict.getName());
                    conflictsStmt.setString(2, nextConflict.getFlags());
                    conflictsStmt.setString(3, nextConflict.getEpoch());
                    conflictsStmt.setString(4, nextConflict.getVersion());
                    conflictsStmt.setString(5, nextConflict.getRelease());
                    conflictsStmt.setInt(6, nextConflict.getPkgKey());
                    conflictsStmt.setInt(3, lk);
                }
                conflictsStmt.executeUpdate();
            }

            if (requiresIterator.hasNext()) {
                while (requiresIterator.hasNext()) {
                    Requires nextRequires = requiresIterator.next();
                    requiresStmt.setString(1, nextRequires.getName());
                    requiresStmt.setString(2, nextRequires.getFlags());
                    requiresStmt.setString(3, nextRequires.getEpoch());
                    requiresStmt.setString(4, nextRequires.getVersion());
                    requiresStmt.setString(5, nextRequires.getRelease());
                    requiresStmt.setInt(6, lk);
                    requiresStmt.setBoolean(7, nextRequires.getPre());
                }
                requiresStmt.executeUpdate();
            }

            if (providesIterator.hasNext()) {
                while (providesIterator.hasNext()) {
                    Provides nextProvides = providesIterator.next();
                    providesStmt.setString(1, nextProvides.getName());
                    providesStmt.setString(2, nextProvides.getFlags());
                    providesStmt.setString(3, nextProvides.getEpoch());
                    providesStmt.setString(4, nextProvides.getVersion());
                    providesStmt.setString(5, nextProvides.getRelease());
                    providesStmt.setInt(6, nextProvides.getPkgKey());
                    providesStmt.setInt(3, lk);
                }
                providesStmt.executeUpdate();
            }
//            
//             CREATE TABLE obsoletes (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
//    CREATE TABLE suggests (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
//    CREATE TABLE enhances (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
//    CREATE TABLE recommends (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
//    CREATE TABLE supplements (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
            if (obsoletesIterator.hasNext()) {
                while (obsoletesIterator.hasNext()) {
                    Obsoletes nextObsoletes = obsoletesIterator.next();
                    obsoletesStmt.setString(1, nextObsoletes.getName());
                    obsoletesStmt.setString(2, nextObsoletes.getFlags());
                    obsoletesStmt.setString(3, nextObsoletes.getEpoch());
                    obsoletesStmt.setString(4, nextObsoletes.getVersion());
                    obsoletesStmt.setString(5, nextObsoletes.getRelease());
                    obsoletesStmt.setInt(6, nextObsoletes.getPkgKey());
                    obsoletesStmt.setInt(3, lk);
                }
                obsoletesStmt.executeUpdate();
            }
            if (suggestsIterator.hasNext()) {
                while (suggestsIterator.hasNext()) {
                    Suggests nextSuggests = suggestsIterator.next();
                    suggestsStmt.setString(1, nextSuggests.getName());
                    suggestsStmt.setString(2, nextSuggests.getFlags());
                    suggestsStmt.setString(3, nextSuggests.getEpoch());
                    suggestsStmt.setString(4, nextSuggests.getVersion());
                    suggestsStmt.setString(5, nextSuggests.getRelease());
                    suggestsStmt.setInt(6, nextSuggests.getPkgKey());
                    suggestsStmt.setInt(3, lk);
                }
                suggestsStmt.executeUpdate();
            }
            if (enhancesIterator.hasNext()) {
                while (enhancesIterator.hasNext()) {
                    Enhances nextEnhances = enhancesIterator.next();
                    enhancesStmt.setString(1, nextEnhances.getName());
                    enhancesStmt.setString(2, nextEnhances.getFlags());
                    enhancesStmt.setString(3, nextEnhances.getEpoch());
                    enhancesStmt.setString(4, nextEnhances.getVersion());
                    enhancesStmt.setString(5, nextEnhances.getRelease());
                    enhancesStmt.setInt(6, nextEnhances.getPkgKey());
                    enhancesStmt.setInt(3, lk);
                }
                enhancesStmt.executeUpdate();
            }
            if (recommendsIterator.hasNext()) {
                while (recommendsIterator.hasNext()) {
                    Recommends nextRecommends = recommendsIterator.next();
                    recommendsStmt.setString(1, nextRecommends.getName());
                    recommendsStmt.setString(2, nextRecommends.getFlags());
                    recommendsStmt.setString(3, nextRecommends.getEpoch());
                    recommendsStmt.setString(4, nextRecommends.getVersion());
                    recommendsStmt.setString(5, nextRecommends.getRelease());
                    recommendsStmt.setInt(6, nextRecommends.getPkgKey());
                    recommendsStmt.setInt(3, lk);
                }
                recommendsStmt.executeUpdate();
            }
            if (supplementsIterator.hasNext()) {
                while (supplementsIterator.hasNext()) {
                    Supplements nextSupplements = supplementsIterator.next();
                    supplementsStmt.setString(1, nextSupplements.getName());
                    supplementsStmt.setString(2, nextSupplements.getFlags());
                    supplementsStmt.setString(3, nextSupplements.getEpoch());
                    supplementsStmt.setString(4, nextSupplements.getVersion());
                    supplementsStmt.setString(5, nextSupplements.getRelease());
                    supplementsStmt.setInt(6, nextSupplements.getPkgKey());
                    supplementsStmt.setInt(3, lk);
                }
                supplementsStmt.executeUpdate();
            }

            dbCon.commit();
        } catch (SQLException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot persist package " + rpm.toString(), ex);
            throw new PersistException("Cannot persist package " + rpm.toString(), ex);
        }

    }

    @Override
    public void close() throws Exception {
        if (packagesStmt != null) {
            try {
                packagesStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close packages statement");
                throw new ClosingException(ex);
            }
        }
        if (filesStmt != null) {
            try {
                filesStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close files statement");
                throw new ClosingException(ex);
            }
        }
        if (lastKey != null) {
            try {
                lastKey.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close last key statement");
                throw new ClosingException(ex);
            }
        }
        if (conflictsStmt != null) {
            try {
                conflictsStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close conflicts statement");
                throw new ClosingException(ex);
            }
        }
        if (requiresStmt != null) {
            try {
                requiresStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close requires statement");
                throw new ClosingException(ex);
            }
        }
        if (providesStmt != null) {
            try {
                providesStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close provides statement");
                throw new ClosingException(ex);
            }
        }
        if (obsoletesStmt != null) {
            try {
                obsoletesStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close obsoletes statement");
                throw new ClosingException(ex);
            }
        }
        if (suggestsStmt != null) {
            try {
                suggestsStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close suggests statement");
                throw new ClosingException(ex);
            }
        }
        if (enhancesStmt != null) {
            try {
                enhancesStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close enhances statement");
                throw new ClosingException(ex);
            }
        }
        if (recommendsStmt != null) {
            try {
                recommendsStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close recommends statement");
                throw new ClosingException(ex);
            }
        }
        if (supplementsStmt != null) {
            try {
                supplementsStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close supplements statement");
                throw new ClosingException(ex);
            }
        }
        if (dbCon != null) {
            try {
                dbCon.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).error("Cannot close connection", ex);
                throw new ClosingException(ex);
            }
        }
    }

}

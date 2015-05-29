/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.other.jdbc;

import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.sqlite.common.Changelog;
import ua.pp.msk.yum.sqlite.common.Persister;
import ua.pp.msk.yum.sqlite.common.RPM;
import ua.pp.msk.yum.sqlite.common.exceptions.PersistException;
import ua.pp.msk.yum.sqlite.exceptions.ClosingException;
import ua.pp.msk.yum.sqlite.InitDb;

/**
 *
 * @author edem
 */
public class OtherPersister implements Persister {

    private static final String PACKAGES_TABLE = "packages";
    private static final String CHANGELOG_TABLE = "changelog";

    public final static String persistDbInfo = "INSERT INTO " + DB_INFO_TABLE + "(dbversion, checksum) VALUES (10 ,?)";

    public final static String persistPakages = " INSERT INTO " + PACKAGES_TABLE + " ( pkgId )  VALUES (?)";
    public final static String getLastPackageKey = "SELECT pkgKey FROM " + PACKAGES_TABLE + " ORDER BY  pkgKey  DESC  LIMIT 1";
    public final static String persistChangelog = "INSERT INTO " + CHANGELOG_TABLE + "(pkgKey, author, date , changelog)  VALUES (?,?,?,?)";

    private PreparedStatement dbInfoStmt;
    private PreparedStatement packagesStmt;
    private PreparedStatement changelogStmt;
    private PreparedStatement lastKey;


    private String dbUrl;
    private String username;
    private String password;

    private Connection dbCon;

    public OtherPersister(String url, String username, String password) {

        this.dbUrl = (url.endsWith(".sqlite")) ? url : url + File.separator + "other.sqlite";
        this.username = username;
        this.password = password;
        init();
    }

    public OtherPersister(Path dbPath, String username, String password) {

        this.dbUrl = "jdbc:sqlite:" + dbPath.toString();
        this.username = username;
        this.password = password;
        init();
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
        idb.setResourceSqlPath("sql/others/InitDB.sql");
        idb.run();
        dbCon = idb.getConnection();
        try {
            lastKey = dbCon.prepareStatement(getLastPackageKey);
            packagesStmt = dbCon.prepareStatement(persistPakages);
            dbInfoStmt = dbCon.prepareStatement(persistDbInfo);
            changelogStmt = dbCon.prepareStatement(persistChangelog);

        } catch (SQLException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot prepare statement " + ex.getMessage(), ex);
        }
    }

    public int getLastPkgKey() {
        int qty = 0;
        try (ResultSet lastKeyResultSet = lastKey.executeQuery()) {

            boolean afterLast = lastKeyResultSet.isAfterLast();
            if (afterLast) {
                LoggerFactory.getLogger(this.getClass()).warn("It seems to be there is no stored packages in the database yet");
            } else {
                lastKeyResultSet.next();
                qty = lastKeyResultSet.getInt(1);
            }

        } catch (SQLException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot last package key " + ex.getMessage(), ex);
        }
        return qty;
    }

    @Override
    public void persist(RPM rpm) throws PersistException {
        Iterator<Changelog> changelogIterator = rpm.getChangelogCollection().iterator();

        int lk = getLastPkgKey() + 1;
        try {
            dbCon.setAutoCommit(false);
            packagesStmt.setString(1, rpm.getPkgId());
            packagesStmt.executeUpdate();
            if (changelogIterator.hasNext()) {
                while (changelogIterator.hasNext()) {
                    Changelog nextFile = changelogIterator.next();
                    changelogStmt.setInt(1, lk);
                    changelogStmt.setString(2, nextFile.getAuthor());
                    changelogStmt.setInt(3, nextFile.getDate());
                    changelogStmt.setString(4, nextFile.getText());
                    changelogStmt.executeUpdate();
                }
            }
            //TODO should be 1 per db
            dbInfoStmt.setInt(1, lk);
            dbInfoStmt.setString(1, "Not supported yet!");
            dbInfoStmt.executeUpdate();

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
        if (changelogStmt != null) {
            try {
                changelogStmt.close();
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
        ;
        if (dbInfoStmt != null) {
            try {
                dbInfoStmt.close();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot close files statement");
                throw new ClosingException(ex);
            }
        }

    }

    @Override
    public void setCompressedChecksum(String compressedChecksum) throws PersistException {
        if (compressedChecksum.length() == 64) {
            try {
                dbInfoStmt.setString(1, compressedChecksum);
                dbInfoStmt.executeUpdate();
            } catch (SQLException ex) {
                LoggerFactory.getLogger(this.getClass()).error("Cannot update DB info", ex);
                throw new PersistException(ex);
            }
        } else {
            LoggerFactory.getLogger(this.getClass()).error("Wrong length " + compressedChecksum.length() + " of sha265 checksum");
        }
    }
}

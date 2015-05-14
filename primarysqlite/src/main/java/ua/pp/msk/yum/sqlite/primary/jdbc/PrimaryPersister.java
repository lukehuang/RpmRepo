/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary.jdbc;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.RpmPackage;
import ua.pp.msk.yum.sqlite.common.Persister;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class PrimaryPersister implements Persister, AutoCloseable {

    private static final String PACKAGES_TABLE = "packages";

    public final static String persistPakages = "INSERT INTO " + PACKAGES_TABLE
            + "(   pkgId ,  name ,  arch ,  version ,  epoch ,  release ,  summary ,  description ,  url ,  time_file ,  time_build ,  rpm_license ,  rpm_vendor ,  rpm_group ,  rpm_buildhost ,  rpm_sourcerpm ,  rpm_header_start ,  rpm_header_end ,  rpm_packager ,  size_package ,  size_installed ,  size_archive ,  location_href ,  location_base ,  checksum_type ) "
            + "VALUES ( ? ,  ? ,  ? ,  ? , ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? , ? ,  ? ,  ? , ? ,  ? ,  ? , ? ,  ? ,  ? ,  ? ,  ?)";

    private PreparedStatement packagesStmt;

    private final Connection dbCon;

    /*
     CREATE TABLE packages (  pkgKey INTEGER PRIMARY KEY,  pkgId TEXT,  name TEXT,  arch TEXT,  version TEXT, 
     epoch TEXT,  release TEXT,  summary TEXT,  description TEXT,  url TEXT,  
     time_file INTEGER,  time_build INTEGER,  rpm_license TEXT,  rpm_vendor TEXT,  
     rpm_group TEXT,  rpm_buildhost TEXT,  rpm_sourcerpm TEXT,  rpm_header_start INTEGER,
     rpm_header_end INTEGER,  rpm_packager TEXT,  size_package INTEGER,  size_installed INTEGER,  
     size_archive INTEGER,  location_href TEXT,  location_base TEXT,  checksum_type TEXT);
     CREATE TABLE files (  name TEXT,  type TEXT,  pkgKey INTEGER);
     */
    public PrimaryPersister(Path dbpath, String username, String password) {

        InitDb idb = new InitDb(dbpath, username, password);
        idb.run();
        dbCon = idb.getConnection();
        try {
            packagesStmt = dbCon.prepareStatement(persistPakages);
        } catch (SQLException ex){
            LoggerFactory.getLogger(this.getClass()).error("Cannot prepare statement " + ex.getMessage(), ex);
        }
                
    }

    @Override
    public void persist(RpmPackage rpm) {
        try {    
        packagesStmt.setString(1,rpm.getPkgId());
        packagesStmt.setString(2,rpm.getName());
        packagesStmt.setString(1,rpm.getPkgId());
        packagesStmt.setString(1,rpm.getPkgId());
        packagesStmt.setString(1,rpm.getPkgId());
        packagesStmt.setString(1,rpm.getPkgId());
        packagesStmt.setString(1,rpm.getPkgId());
        packagesStmt.setString(1,rpm.getPkgId());
        packagesStmt.setString(1,rpm.getPkgId());
        packagesStmt.setString(1,rpm.getPkgId());
        packagesStmt.setString(1,rpm.getPkgId());
        
        } catch (SQLException ex ) {
             LoggerFactory.getLogger(this.getClass()).error("Cannot prepare statement " + ex.getMessage(), ex);
        }
        
        
        
        
        try {
        dbCon.setAutoCommit(false);
        packagesStmt.executeUpdate();
        
        
        
        
        dbCon.commit();
        } catch (SQLException ex) {
            
        }
        
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

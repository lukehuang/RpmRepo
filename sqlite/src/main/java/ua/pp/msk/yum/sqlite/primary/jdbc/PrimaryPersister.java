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
import ua.pp.msk.yum.sqlite.RpmPackage;





/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class PrimaryPersister implements Persister, AutoCloseable {

    private static final String PACKAGES_TABLE = "packages";
    private static final String FILES_TABLE = "files";
     private static final String CONFLICTS_TABLE = "conflicts";
     

    public final static String persistPakages = "INSERT INTO " + PACKAGES_TABLE
            + "(   pkgId ,  name ,  arch ,  version ,  epoch ,  release ,  summary ,  description ,  url ,  time_file ,  time_build ,  rpm_license ,  rpm_vendor ,  rpm_group ,  rpm_buildhost ,  rpm_sourcerpm ,  rpm_header_start ,  rpm_header_end ,  rpm_packager ,  size_package ,  size_installed ,  size_archive ,  location_href ,  location_base ,  checksum_type ) "
            + "VALUES ( ? ,  ? ,  ? ,  ? , ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? , ? ,  ? ,  ? , ? ,  ? ,  ? , ? ,  ? ,  ? ,  ? ,  ?)";
    public final static String persistFiles = "INSERT INTO " + FILES_TABLE+"(name, type, pkgKey) VALUES (? ,?, ?)";
    public final static String getLastPackageKey = "SELECT pkgKey FROM "+PACKAGES_TABLE+" ORDER BY  pkgKey  DESC  LIMIT 1";
    public final static String persistConflicts = "INSERT INTO " + CONFLICTS_TABLE+"(name, flags,  epoch,  version ,  release , pkgKey) VALUES (? ,?, ?, ?, ?, ?)";
    
    private PreparedStatement packagesStmt;
    private PreparedStatement filesStmt;
    private PreparedStatement lastKey;
      private PreparedStatement conflictsStmt;

    private final Connection dbCon;

    /*
     
     CREATE TABLE files (  name TEXT,  type TEXT,  pkgKey INTEGER);
    CREATE TABLE conflicts (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
     */
    public PrimaryPersister(Path dbpath, String username, String password) {

        InitDb idb = new InitDb(dbpath, username, password);
        idb.run();
        dbCon = idb.getConnection();
        try {            lastKey = dbCon.prepareStatement(getLastPackageKey);

            packagesStmt = dbCon.prepareStatement(persistPakages);
            filesStmt = dbCon.prepareStatement(persistFiles);
            conflictsStmt = dbCon.prepareStatement(persistConflicts);
        } catch (SQLException ex){
            LoggerFactory.getLogger(this.getClass()).error("Cannot prepare statement " + ex.getMessage(), ex);
        }
                
    }

    
    public int getLastPkgKey(){
        int qty = 0 ;
        try {
            ResultSet lastKeyResultSet = lastKey.executeQuery();
            qty = lastKeyResultSet.last()?lastKeyResultSet.getInt(1) : 0;
            
        
        } catch (SQLException ex) {
          LoggerFactory.getLogger(this.getClass()).error("Cannot prepare statement " + ex.getMessage(), ex);
        }
       return qty;
    }
    
    
    @Override
    public void persist(RpmPackage rpm) {
        Iterator<Files> filesIterator = rpm.getFilesCollection().iterator();
         Iterator<Conflicts> conflictsIterator = rpm.getConflictsCollection().iterator();
       int lk = getLastPkgKey() + 1;
        try {    
            dbCon.setAutoCommit(false);
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
        
      
        
      
        
        packagesStmt.executeUpdate();
        
        while (filesIterator.hasNext()){
                Files nextFile = filesIterator.next();
            filesStmt.setString(1, nextFile.getName());
            filesStmt.setString(2, nextFile.getType());
            filesStmt.setInt(3, lk);
        }
        
         while (conflictsIterator.hasNext()){
                Conflicts nextFile = filesIterator.next();
            conflictsStmt.setString(1, nextFile.getName());
            conflictsStmt.setString(2, nextFile.getType());
            conflictsStmt.setInt(3, lk);
        }
        
        
        dbCon.commit();
        } catch (SQLException ex) {
            
        }
        
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary.jdbc;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.sqlite.common.ResourceReader;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class InitDb implements Runnable, AutoCloseable {

    //Database schema initialization query
    //Todo implement db_info fill up
/*
     CREATE TABLE db_info (dbversion INTEGER, checksum TEXT);
     CREATE TABLE packages (  pkgKey INTEGER PRIMARY KEY,  pkgId TEXT,  name TEXT,  arch TEXT,  version TEXT,  epoch TEXT,  release TEXT,  summary TEXT,  description TEXT,  url TEXT,  time_file INTEGER,  time_build INTEGER,  rpm_license TEXT,  rpm_vendor TEXT,  rpm_group TEXT,  rpm_buildhost TEXT,  rpm_sourcerpm TEXT,  rpm_header_start INTEGER,  rpm_header_end INTEGER,  rpm_packager TEXT,  size_package INTEGER,  size_installed INTEGER,  size_archive INTEGER,  location_href TEXT,  location_base TEXT,  checksum_type TEXT);
     CREATE TABLE files (  name TEXT,  type TEXT,  pkgKey INTEGER);
     CREATE TABLE requires (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER , pre BOOLEAN DEFAULT FALSE);
     CREATE TABLE provides (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
     CREATE TABLE conflicts (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
     CREATE TABLE obsoletes (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
     CREATE TABLE suggests (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
     CREATE TABLE enhances (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
     CREATE TABLE recommends (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
     CREATE TABLE supplements (  name TEXT,  flags TEXT,  epoch TEXT,  version TEXT,  release TEXT,  pkgKey INTEGER );
     CREATE TRIGGER removals AFTER DELETE ON packages  BEGIN    DELETE FROM files WHERE pkgKey = old.pkgKey;    DELETE FROM requires WHERE pkgKey = old.pkgKey;    DELETE FROM provides WHERE pkgKey = old.pkgKey;    DELETE FROM conflicts WHERE pkgKey = old.pkgKey;    DELETE FROM obsoletes WHERE pkgKey = old.pkgKey;    DELETE FROM suggests WHERE pkgKey = old.pkgKey;    DELETE FROM enhances WHERE pkgKey = old.pkgKey;    DELETE FROM recommends WHERE pkgKey = old.pkgKey;    DELETE FROM supplements WHERE pkgKey = old.pkgKey;  END;
     CREATE INDEX packagename ON packages (name);
     CREATE INDEX packageId ON packages (pkgId);
     CREATE INDEX filenames ON files (name);
     CREATE INDEX pkgfiles ON files (pkgKey);
     CREATE INDEX pkgrequires on requires (pkgKey);
     CREATE INDEX requiresname ON requires (name);
     CREATE INDEX pkgprovides on provides (pkgKey);
     CREATE INDEX providesname ON provides (name);
     CREATE INDEX pkgconflicts on conflicts (pkgKey);
     CREATE INDEX pkgobsoletes on obsoletes (pkgKey);
     CREATE INDEX pkgsuggests on suggests (pkgKey);
     CREATE INDEX pkgenhances on enhances (pkgKey);
     CREATE INDEX pkgrecommends on recommends (pkgKey);
     CREATE INDEX pkgsupplements on supplements (pkgKey);
     */
    public InitDb(Path sqliteDbPath, String username, String password) {
        this("jdbc:sqlite:" + sqliteDbPath.toString(), username, password);
        LoggerFactory.getLogger(this.getClass()).debug("Setting sqlite database path to " + sqliteDbPath.toString());
    }

    public InitDb(String url, String username, String password) {
        //TODO check files existence 
        LoggerFactory.getLogger(this.getClass()).debug("Setting sqlite URL to " + url);
        DB_URL = url;
        USER = (username == null) ? "" : username;
        PASS = (password == null) ? "" : password;
    }

    // JDBC driver name and database URL
    private final String JDBC_DRIVER = "org.sqlite.JDBC";
    private final String DB_URL;

    //  Database credentials
    private final String USER;
    private final String PASS;

    private Connection conn = null;
    private Statement stmt = null;

    @Override
    public void run() {

        try {
//We do not need it in JDBS Driver version 4
//      //STEP 2: Register JDBC driver
//      Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            LoggerFactory.getLogger(this.getClass()).debug("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            LoggerFactory.getLogger(this.getClass()).debug("Creating database...");
            stmt = conn.createStatement();

            String sql = ResourceReader.readFile("sql/InitDB.sql", getClass().getClassLoader());
            LoggerFactory.getLogger(this.getClass()).debug("About to execute query:\n" + sql);
            stmt.executeUpdate(sql);
            LoggerFactory.getLogger(this.getClass()).debug("Database created successfully...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            LoggerFactory.getLogger(this.getClass()).error("SQL exception " + se.getMessage(), se);
        }

    }//end main

    @Override
    public void close() throws Exception {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException se2) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot close database statement " + se2.getMessage(), se2);
        }// nothing we can do
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot close database connection" + se.getMessage(), se);
        }//end finally try
    }

    public String getDatabaseUrl() {
        return DB_URL;
    }

    public String getUser() {
        return USER;
    }

    public Connection getConnection() {
        return conn;
    }

}

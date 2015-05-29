/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

 
    
   
    public InitDb(Path sqliteDbPath, String username, String password) {
        this("jdbc:sqlite:" + sqliteDbPath.toString(), username, password);
        LoggerFactory.getLogger(this.getClass()).debug("Setting sqlite database path to " + sqliteDbPath.toString());
    }
    
    
     public InitDb(Path sqliteDbPath, String username, String password, String sqlResource) {
     this (sqliteDbPath, username, password);
     this.resourceSqlPath = sqlResource;
     }

     public InitDb(String url, String username, String password, String sqlResource) {
         this(url, username, password);
          this.resourceSqlPath = sqlResource;
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
       
    private String resourceSqlPath;
    private String dbInitStatements;

    private boolean checkFileExistence() {
        if (DB_URL != null && DB_URL.length() > 12) {
            Path dbPath = Paths.get(DB_URL.replaceAll("jdbc:sqlite:", ""));
            boolean exists = Files.exists(dbPath);
            LoggerFactory.getLogger(this.getClass()).debug("Database file " + dbPath.toAbsolutePath().toString() + (exists ? " exists" : " does not exist"));
            return exists;
        } else {
            LoggerFactory.getLogger(this.getClass()).warn("Looks like database url is malformed " + DB_URL);
            return false;
        }
    }

    public String getResourceSqlPath() {
        return resourceSqlPath;
    }

    public void setResourceSqlPath(String resourceSqlPath) {
        this.resourceSqlPath = resourceSqlPath;
    }

    public String getDbInitStatements() {
        return dbInitStatements;
    }

    public void setDbInitStatements(String dbInitStatements) {
        this.dbInitStatements = dbInitStatements;
    }
    
    

    @Override
    public void run() {

        try {

//We do not need it in JDBS Driver version 4
//      //STEP 2: Register JDBC driver
//      Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            //Check DB Existence firstly
            if (checkFileExistence()) {
                LoggerFactory.getLogger(this.getClass()).warn("Database file exists, will not create new database. Skipping initialize new database");
                LoggerFactory.getLogger(this.getClass()).debug("Connecting to the brand new database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } else {
                LoggerFactory.getLogger(this.getClass()).debug("Connecting to existing database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                //STEP 4: Execute a query
                LoggerFactory.getLogger(this.getClass()).debug("Creating database...");
                stmt = conn.createStatement();
                String sql;
                if (dbInitStatements == null || dbInitStatements.isEmpty()){
                    sql = ResourceReader.readFile(resourceSqlPath, getClass().getClassLoader());
                } else {
                    sql = dbInitStatements;
                }
                LoggerFactory.getLogger(this.getClass()).debug("About to execute query:\n" + sql);
                stmt.executeUpdate(sql);
                LoggerFactory.getLogger(this.getClass()).debug("Database created successfully...");
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            LoggerFactory.getLogger(this.getClass()).error("SQL exception " + se.getMessage(), se);
        }
        //TODO handle resource not found exception

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

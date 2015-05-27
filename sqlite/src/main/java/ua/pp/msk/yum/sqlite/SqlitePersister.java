/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import ua.pp.msk.yum.persist.AbstractPersister;

import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.sqlite.exceptions.DbPathException;
import ua.pp.msk.yum.sqlite.filelist.jdbc.FilelistPersister;
import ua.pp.msk.yum.sqlite.other.jdbc.OtherPersister;
import ua.pp.msk.yum.sqlite.primary.jdbc.PrimaryPersister;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class SqlitePersister extends AbstractPersister {

    private static SqlitePersister pr = null;

    /**
     *
     * @param path File system path to the folder where sqlite databases should
     * exist
     * @return Instance of SqlitePersister
     */
    public static SqlitePersister getPersister(String path) {

        if (pr == null) {
            synchronized (SqlitePersister.class) {
                if (pr == null) {
                    pr = new SqlitePersister(path);
                }
            }
        }

        return pr;
    }
     public static SqlitePersister getPersister(File file) {

        if (pr == null) {
            synchronized (SqlitePersister.class) {
                if (pr == null) {
                    pr = new SqlitePersister(file);
                }
            }
        }

        return pr;
    }

    private SqlitePersister(String path) {
        super();
        try {
            ensurePath(path, "primary");
            addPersister(new PrimaryPersister("jdbc:sqlite:" + path, null, null));
            addPersister(new OtherPersister("jdbc:sqlite:" + path, null, null));
            addPersister(new FilelistPersister("jdbc:sqlite:" + path, null, null));
        } catch (DbPathException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Database path error " + ex.getMessage(), ex);
        }
        //TODO add two more persisters here
    }
    private SqlitePersister(File file) {
       this(file.getAbsolutePath());
    }
/**
 * 
 * @param url Database URL for JDBS to connect
 * @param dbName Database name without .sqlite ending
 * @return Path to the database
 */
    private Path getSqliteDbPath(String url, String dbName) {
        String stringPath = url.replaceAll("jdbc:sqlite:", "");
        if (stringPath.endsWith(dbName + ".sqlite")) {
            return Paths.get(stringPath);
        } else {
            return Paths.get(stringPath+ File.separator + dbName + ".sqlite");
        }
    }

    public final void ensurePath(String path, String dbName) throws DbPathException {

        Path sqliteDbPath = getSqliteDbPath(path, dbName);
        Path parentPath = sqliteDbPath.getParent();
        LoggerFactory.getLogger(this.getClass()).debug("Parent folder of database "+path+" path: " + parentPath.toAbsolutePath().toString());
        if (!Files.exists(parentPath)) {
            LoggerFactory.getLogger(this.getClass()).warn("Parent directory for database " + sqliteDbPath.toAbsolutePath() + "does not exist. Will attempt to create it");
            try {
                Files.createDirectories(parentPath);
                LoggerFactory.getLogger(this.getClass()).info("Parent directory " + parentPath.toAbsolutePath() + " dor database " + sqliteDbPath.toString() + " has been successfuly created");
            } catch (IOException ex) {
                LoggerFactory.getLogger(this.getClass()).error("Parent directory " + parentPath.toAbsolutePath() + " dor database " + sqliteDbPath.toString() + " has been failed to create");
                throw new DbPathException("Could not ensure path for database " + sqliteDbPath.toAbsolutePath().toString(), ex);
            }
        }
        if (!Files.exists(sqliteDbPath)) {
            LoggerFactory.getLogger(this.getClass()).info("Database (path: " + sqliteDbPath + ") does not exist.");
        }

    }
        //TODO use it later
//            if (filelist != null) {
//                filelistUrlSplit = filelist.getProperties().get("javax.persistence.jdbc.url").toString().split(":");
//                LoggerFactory.getLogger(this.getClass()).debug("FileList db path: " + filelistUrlSplit[filelistUrlSplit.length - 1]);
//                ensurePath(filelistUrlSplit[filelistUrlSplit.length - 1]);
//            }
//
//            if (others != null) {
//                othersUrlSplit = others.getProperties().get("javax.persistence.jdbc.url").toString().split(":");
//                LoggerFactory.getLogger(this.getClass()).debug("Others db path: " + othersUrlSplit[othersUrlSplit.length - 1]);
//                ensurePath(othersUrlSplit[othersUrlSplit.length - 1]);
//            }
//        } catch (IOException ex) {
//            LoggerFactory.getLogger(this.getClass()).error("Cannot create db directory", ex);
//        }
//         Map<String, Object> primaryProperties = primary.getProperties();
//        for (Map.Entry<String,Object> p: primaryProperties.entrySet()){
//            LoggerFactory.getLogger(this.getClass()).debug("Primary property key: " + p.getKey() + " value: " + p.getValue());
//        }

//    public void moveToTemp(){
//        Iterator<Persister> iterator = getPersisters().iterator();
//        while (iterator.hasNext()){
//            Persister np = iterator.next();
//            Path dbPath = Paths.get(np.getDbUrl().replaceAll("jdbc:sqlite:", ""));
//            Path parentDbPath = dbPath.getParent();
//            parentDbPath.
//            Files.copy(dbPath, dbPath, options)
//            
//        }
//    }
}

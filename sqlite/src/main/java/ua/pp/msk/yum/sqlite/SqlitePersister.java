/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import ua.pp.msk.yum.persist.AbstractPersister;

import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.sqlite.common.Persister;
import ua.pp.msk.yum.sqlite.common.RPM;
import ua.pp.msk.yum.sqlite.common.exceptions.PersistException;
import ua.pp.msk.yum.sqlite.exceptions.DbPathException;
import ua.pp.msk.yum.sqlite.primary.jdbc.PrimaryPersister;


/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class SqlitePersister extends AbstractPersister {

    
    private static SqlitePersister pr = null;

    /**
     * 
     * @param path File system path to the folder where sqlite databases should exist 
     * @return Instance of SqlitePersister
     */
    public static SqlitePersister getPersister(String path) {
        synchronized (SqlitePersister.class) {
            if (pr == null) {
                synchronized (SqlitePersister.class) {
                    pr = new SqlitePersister(path);
                }
            }
        }
        return pr;
    }

    private SqlitePersister(String path) {
        super();
        addPersister(new PrimaryPersister("jdbc:sqlite:"+path, null, null));
       //TODO add two more persisters here
    }

    private Path getSqliteDbPath(Persister p){
        String stringPath = p.getDbUrl().replaceAll("jdbc:sqlite:", "");
        return Paths.get(stringPath);
    }
   

        public void ensurePath() throws DbPathException {
        

        Iterator<Persister> persisterIterator = getPersisters().iterator();
        while(persisterIterator.hasNext()){
            Persister nextPersister = persisterIterator.next();
            Path sqliteDbPath = getSqliteDbPath(nextPersister);
            Path parentPath = sqliteDbPath.getParent();
            if (!Files.exists(parentPath)){
                LoggerFactory.getLogger(this.getClass()).warn("Parent directory for database "+sqliteDbPath.toAbsolutePath() + "does not exist. Will attempt to create it");
                try {
                    Files.createDirectories(parentPath);
                    LoggerFactory.getLogger(this.getClass()).info("Parent directory " + parentPath.toAbsolutePath()+" dor database " + sqliteDbPath.toString() + " has been successfuly created");
                } catch (IOException ex) {
                    LoggerFactory.getLogger(this.getClass()).error("Parent directory " + parentPath.toAbsolutePath()+" dor database " + sqliteDbPath.toString() + " has been failed to create");
                    throw new DbPathException("Could not ensure path for database " + sqliteDbPath.toAbsolutePath().toString() ,  ex);
                }
            }
            if (!Files.exists(getSqliteDbPath(nextPersister))){
                LoggerFactory.getLogger(this.getClass()).info("Database (URL: "+ nextPersister.getDbUrl()+") does not exist.");
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
    }

    @Override
    public synchronized void persist(RPM rpm) throws PersistException {
        try {
        ensurePath();
        super.persist(rpm); //To change body of generated methods, choose Tools | Templates.
        } catch (DbPathException ex){
            throw new PersistException(ex);
        }
                
    }

   

}

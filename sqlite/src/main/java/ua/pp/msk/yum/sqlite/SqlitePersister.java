/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite;

import java.sql.Connection;
import java.util.Map;
import ua.pp.msk.yum.persist.AbstractPersister;

import org.slf4j.LoggerFactory;


/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class SqlitePersister extends AbstractPersister {

    
    private static SqlitePersister pr = null;

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

       
    }

   

    @Override
    public void close() throws Exception {
        LoggerFactory.getLogger(this.getClass()).info("Closing primary db");
        if (primary != null) {
            primary.close();
        }
        LoggerFactory.getLogger(this.getClass()).info("Closing filelists db");
        if (filelist != null) {
            filelist.close();
        }
        LoggerFactory.getLogger(this.getClass()).info("Closing others db");
        if (others != null) {
            others.close();
        }
    }

   

    public void ensurePath() {
        Map<String, Object> primaryProperties = primary.getProperties();
        for (Map.Entry<String, Object> p : primaryProperties.entrySet()) {
            LoggerFactory.getLogger(this.getClass()).debug("Primary property key: " + p.getKey() + " value: " + p.getValue());
        }
        String[] primaryUrlSplit;
        String[] filelistUrlSplit;
        String[] othersUrlSplit;

        //try {
            if (primary != null) {
                primaryUrlSplit = primary.getProperties().get("javax.persistence.jdbc.url").toString().split(":");
                LoggerFactory.getLogger(this.getClass()).debug("Primary db path: " + primaryUrlSplit[primaryUrlSplit.length - 1]);
               // PrimarySqlite.ensurePath(primaryUrlSplit[primaryUrlSplit.length - 1]);

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

   

}

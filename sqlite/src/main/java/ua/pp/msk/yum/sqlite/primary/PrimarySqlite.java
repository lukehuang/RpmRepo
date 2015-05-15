/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceUnitInfo;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.internal.jpa.deployment.SEPersistenceUnitInfo;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class PrimarySqlite {

    public static EntityManager getEntityManager() {
        String userDir = System.getProperty("user.dir");
        return getEntityManger(userDir);
    }

    public static EntityManager getEntityManger(String path) {
        EntityManager primaryEm = null;
        try {
        ensurePath(path);
        Map<String, Object> primaryProperties = new HashMap<>();
        primaryProperties.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
        primaryProperties.put("javax.persistence.jdbc.url", "jdbc:sqlite:" + path);
        primaryProperties.put("javax.persistence.jdbc.user", "");
        primaryProperties.put("javax.persistence.jdbc.driver", "org.sqlite.JDBC");
        primaryProperties.put("javax.persistence.jdbc.password", "");
       
        primaryProperties.put("javax.persistence.schema-generation.database.action", PersistenceUnitProperties.SCHEMA_GENERATION_DROP_AND_CREATE_ACTION);
           
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
//          EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
        Map<String, Object> properties = emf.getProperties();
        for (Map.Entry<String, Object> me : properties.entrySet()){
            LoggerFactory.getLogger(PrimarySqlite.class).debug("PrimarySqlite EntityManagerFactory " + emf.getClass().getCanonicalName() + " key:" + me.getKey() + " value: " + me.getValue());
        }
        primaryEm= emf.createEntityManager(primaryProperties);
         Map<String, Object> emProperties = primaryEm.getProperties();
        for (Map.Entry<String, Object> me : emProperties.entrySet()){
            LoggerFactory.getLogger(PrimarySqlite.class).debug("PrimarySqlite EntityManager " + primaryEm.getClass().getCanonicalName() + " key:" + me.getKey() + " value: " + me.getValue());
        }
        } catch (IOException ex) {
            LoggerFactory.getLogger(PrimarySqlite.class).error("Cannot create path " + path , ex);
        }
       
        return primaryEm;
    }
     public static void ensurePath(String path) throws IOException {
        ensurePath(Paths.get(path));
    }

    public static void ensurePath(Path path) throws IOException {
        if (java.nio.file.Files.isDirectory(path)) {
            java.nio.file.Files.createDirectories(path);
        }
    }
}

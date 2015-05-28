/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary.jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.slf4j.LoggerFactory;

/**
 *
 * @author maskimko
 */
public class InitDbTest {

    private static final String DB_FOLDER_LOCATION = "/tmp/testrepo";

    public InitDbTest() {
    }

    @Before
    public void init() {

        Path parentDb = Paths.get(DB_FOLDER_LOCATION);
        try {
            if (!Files.exists(parentDb)) {
                Files.createDirectories(parentDb);
            }
        } catch (IOException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot create test directory", ex);
        }
    }

    /**
     * Test of run method, of class InitDb.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Path tdb = Paths.get(DB_FOLDER_LOCATION, "testDb.sqlite");

        InitDb instance = new InitDb(tdb, null, null);
        instance.run();
        try {
            instance.close();
        } catch (Exception ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot close db", ex);
        }
        assertTrue(Files.exists(tdb));
    }

    @After
    public void shutdown() {
        Path parentDb = Paths.get(DB_FOLDER_LOCATION);
        Path tdb = Paths.get(DB_FOLDER_LOCATION, "testDb.sqlite");
        try {
              if (Files.exists(tdb)) {
                Files.delete(tdb);
            }
            if (Files.exists(parentDb)) {
                Files.delete(parentDb);
            }
          
        } catch (IOException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot delete file", ex);
        }
    }

}

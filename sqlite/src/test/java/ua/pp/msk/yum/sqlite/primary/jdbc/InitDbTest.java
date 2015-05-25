/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary.jdbc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.slf4j.LoggerFactory;

/**
 *
 * @author maskimko
 */
public class InitDbTest {
    
    
    public InitDbTest() {
    }
    
    @Before
    public void init(){
        
    }
    

    /**
     * Test of run method, of class InitDb.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Path tdb = Paths.get("/tmp/testrepo/test_sqlitedb.sqlite");
        InitDb instance = new InitDb(tdb, null, null );
        instance.run();
        try {
            instance.close();
        } catch (Exception ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot close db", ex);
        }
        assertTrue(Files.exists(tdb));
    }

  
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.createrepo;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.CreateRepo;


/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class Starter {
    
    private static final Logger LOG = LoggerFactory.getLogger(Starter.class);
    
    public static void main(String[] args) throws Exception {
        
        CreateRepo cr = new CreateRepo( new File("/tmp/testrepo"), new File("/tmp/testrepo"));
//        LOG.debug("Executing repo creation");
        cr.execute();
    }
}

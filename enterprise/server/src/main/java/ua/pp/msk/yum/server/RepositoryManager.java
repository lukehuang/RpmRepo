/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.server;

import java.io.File;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.createrepoutils.CreateRepo;



/**
 *
 * @author maskimko
 */
@Stateless
@LocalBean
public class RepositoryManager implements Serializable {

     public boolean createRepositoty(String repoPath) {
        boolean result = false;
        if (repoPath != null && !repoPath.isEmpty()) {
                   LoggerFactory.getLogger(this.getClass()).debug("Should create repository at " + repoPath);
     
            CreateRepo cr = new CreateRepo(new File(repoPath), new File(repoPath));
            try {
                cr.execute();
                result = true;
                LoggerFactory.getLogger(this.getClass()).info("Repository " + repoPath + " should be " + ((result) ? "created" : "not created"));
            } catch (Exception ex) {
                LoggerFactory.getLogger(this.getClass()).error("Cannot create repository", ex);
                result = false;
            }
        } else {
            LoggerFactory.getLogger(this.getClass()).warn("Repository path is empty or null");
        }
        return result;
    }

    
    
   
}

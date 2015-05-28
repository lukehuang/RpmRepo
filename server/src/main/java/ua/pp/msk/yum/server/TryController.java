/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.server;

import ua.pp.msk.yum.persist.server.RepositoryManager;
import java.io.File;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.createrepoutils.CreateRepo;



/**
 *
 * @author maskimko
 */
@Stateless
@Remote(value = RepositoryManager.class)
@Local(value = RepositoryManager.class)
public class TryController implements RepositoryManager{

    private String repoPath;
    
    @Override
    public void setRepositoryPath(String path) {
        this.repoPath = path;
    }

    @Override
    public boolean createRepositoty() {
        boolean result = false;
        if (repoPath != null && !repoPath.isEmpty()) {
                
            CreateRepo cr = new CreateRepo(new File(repoPath), new File(repoPath));
            try {
                cr.execute();
                result = true;
            } catch (Exception ex) {
                LoggerFactory.getLogger(this.getClass()).error("Cannot create repository", ex);
                result = false;
            }
        }
        return result;
    }

    
    
   
}

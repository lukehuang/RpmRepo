/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.server;

import java.io.File;
import javax.ejb.Stateless;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.createrepoutils.CreateRepo;



/**
 *
 * @author maskimko
 */
@Stateless
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

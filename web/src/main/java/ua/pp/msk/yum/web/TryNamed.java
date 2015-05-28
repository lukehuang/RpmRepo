/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.web;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import ua.pp.msk.yum.server.TryController;

/**
 *
 * @author maskimko
 */
@Named(value = "tryNamed")
@Dependent
public class TryNamed {

    @Inject
    private TryController tc;
    
    private String repoPath;
    /**
     * Creates a new instance of TryNamed
     */
    public TryNamed() {
        
    }

    public String getRepoPath() {
        return repoPath;
    }

    public void setRepoPath(String repoPath) {
        this.repoPath = repoPath;
    }
    
    public String createRepo(){
        tc.setRepositoryPath(repoPath);
        tc.createRepositoty();
        return "created";
    }
}

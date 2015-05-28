/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.server.RepositoryManager;

/**
 *
 * @author maskimko
 */
@Named(value = "createrepo")
@SessionScoped
public class Createrepo implements Serializable {

    @EJB
    RepositoryManager rman;

    private String repoDir;

    /**
     * Creates a new instance of Createrepo
     */
    public Createrepo() {
    }

    public String getRepoDir() {
        return repoDir;
    }

    public void setRepoDir(String repoDir) {
        this.repoDir = repoDir;
    }

    public String create() {
        LoggerFactory.getLogger(this.getClass()).info("About to create repository at " + repoDir);
        rman.setRepositoryPath(repoDir);
        boolean isCreated = rman.createRepositoty();
        LoggerFactory.getLogger(this.getClass()).info("Repository has been " + ((isCreated) ? "created" : "not created"));
        return (isCreated) ? "created" : "notcreated";
    }

}

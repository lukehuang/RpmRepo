/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.server;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author maskimko
 */
@Local
@Remote
public interface RepositoryManager {
    void setRepositoryPath(String path);
    boolean createRepositoty();
}

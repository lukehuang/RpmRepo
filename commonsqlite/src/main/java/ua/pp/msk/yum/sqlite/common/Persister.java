/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.common;

import ua.pp.msk.yum.RpmPackage;

/**
 *
 * @author maskimko
 */
public interface Persister {
    public void persist(RpmPackage rpm);
}

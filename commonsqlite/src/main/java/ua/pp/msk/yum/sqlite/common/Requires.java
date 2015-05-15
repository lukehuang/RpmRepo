/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.common;

/**
 *
 * @author edem
 */
public interface Requires extends Entry {

    int getPkgKey();

    boolean getPre();

    void setPkgKey(int pkgKey);

    void setPre(boolean pre);

}

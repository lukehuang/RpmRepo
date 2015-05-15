/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.common;

import java.io.Serializable;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public interface Changelog extends Serializable {

    String getChangelog();

    int getPkgKey();

    void setChangelog(String changelog);

    void setPkgKey(int pkgKey);

}

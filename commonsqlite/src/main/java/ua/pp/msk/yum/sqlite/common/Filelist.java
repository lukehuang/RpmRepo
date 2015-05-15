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
public interface Filelist extends Serializable {

    String getDirname();

    String getFilenames();

    String getFiletypes();

    int getPkgKey();

    void setDirname(String dirname);

    void setFilenames(String filenames);

    void setFiletypes(String filetypes);

    void setPkgKey(int pkgKey);

}

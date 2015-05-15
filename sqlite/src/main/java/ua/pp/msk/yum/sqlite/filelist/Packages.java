/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.filelist;

import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class Packages implements Serializable {

    
 
    private static final long serialVersionUID = 1L;
    private Integer pkgKey;
   
    private Collection<Filelist> filelistCollection;

    public Packages() {
    }

    public Integer getPkgKey() {
        return pkgKey;
    }

    public void setPkgKey(Integer pkgKey) {
        this.pkgKey = pkgKey;
    }

 

    public Collection<Filelist> getFilelistCollection() {
        return filelistCollection;
    }

    public void setFilelistCollection(Collection<Filelist> filelist1Collection) {
        this.filelistCollection = filelist1Collection;
    }

 

}

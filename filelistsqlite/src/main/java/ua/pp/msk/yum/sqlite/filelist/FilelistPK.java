/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.filelist;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Embeddable
public class FilelistPK implements Serializable {

    private String dirname;
    private String filenames;

    public FilelistPK() {
    }

    public FilelistPK(String dirname, String filenames) {
        this.dirname = dirname;
        this.filenames = filenames;
    }

    public String getDirname() {
        return dirname;
    }

    public void setDirname(String dirname) {
        this.dirname = dirname;
    }

    public String getFilenames() {
        return filenames;
    }

    public void setFilenames(String filenames) {
        this.filenames = filenames;
    }

    
    
}

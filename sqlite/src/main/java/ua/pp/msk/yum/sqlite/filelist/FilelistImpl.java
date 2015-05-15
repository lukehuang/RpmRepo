/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.filelist;

import java.io.Serializable;


/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */

public class FilelistImpl implements Filelist {
    private static final long serialVersionUID = 1L;
      
    private long id;
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
    protected FilelistPK filelistPK;
    
    private String filetypes;
    private Packages pkgKey;

    public FilelistImpl() {
        this.filelistPK = new FilelistPK();
    }

    public FilelistImpl(FilelistPK filelistPK) {
        this.filelistPK = filelistPK;
    }
    public FilelistImpl( String dir, String filename){
        this(new FilelistPK(filename, dir));
        //TODO implement filetype column
        
    }

    @Override
    public FilelistPK getFilelistPK() {
        return filelistPK;
    }

    @Override
    public void setFilelistPK(FilelistPK filelistPK) {
        this.filelistPK = filelistPK;
    }

    @Override
    public String getDirname() {
        return filelistPK.getDirname();
    }

    @Override
    public void setDirname(String dirname) {
        this.filelistPK.setDirname(dirname);
    }

    @Override
    public String getFilenames() {
        return filelistPK.getFilenames();
    }

    @Override
    public void setFilenames(String filenames) {
        this.filelistPK.setFilenames(filenames);
    }

    @Override
    public String getFiletypes() {
        return filetypes;
    }

    @Override
    public void setFiletypes(String filetypes) {
        this.filetypes = filetypes;
    }

    @Override
    public Packages getPkgKey() {
        return pkgKey;
    }

    @Override
    public void setPkgKey(Packages pkgKey) {
        this.pkgKey = pkgKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filelistPK != null ? filelistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilelistImpl)) {
            return false;
        }
        FilelistImpl other = (FilelistImpl) object;
        if ((this.filelistPK == null && other.filelistPK != null) || (this.filelistPK != null && !this.filelistPK.equals(other.filelistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.Filelist[ filelistPK=" + filelistPK + " ]";
    }

}

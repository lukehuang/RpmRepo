/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.filelist;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Entity
@Table(name = "filelist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filelist.findAll", query = "SELECT f FROM Filelist f"),
    @NamedQuery(name = "Filelist.findByDirname", query = "SELECT f FROM Filelist f WHERE f.dirname = :dirname"),
    @NamedQuery(name = "Filelist.findByFilenames", query = "SELECT f FROM Filelist f WHERE f.filenames = :filenames"),
    @NamedQuery(name = "Filelist.findByFiletypes", query = "SELECT f FROM Filelist f WHERE f.filetypes = :filetypes")})
public class Filelist implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FilelistPK filelistPK;
    @Column(name = "dirname")
    private String dirname;
    @Column(name = "filenames")
    private String filenames;
    @Column(name = "filetypes")
    private String filetypes;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgId")
    @ManyToOne
    private Packages pkgKey;

    public Filelist() {
    }

    public Filelist(FilelistPK filelist1PK) {
        this.filelistPK = filelist1PK;
    }

    public FilelistPK getFilelist1PK() {
        return filelistPK;
    }

    public void setFilelist1PK(FilelistPK filelist1PK) {
        this.filelistPK = filelist1PK;
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

    public String getFiletypes() {
        return filetypes;
    }

    public void setFiletypes(String filetypes) {
        this.filetypes = filetypes;
    }

    public Packages getPkgKey() {
        return pkgKey;
    }

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
        if (!(object instanceof Filelist)) {
            return false;
        }
        Filelist other = (Filelist) object;
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

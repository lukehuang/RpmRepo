/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@XmlRootElement
public class FilesImpl implements Files {
    private static final long serialVersionUID = 1L;
    private String name;
    private String type;
    private Packages pkgKey;

    public FilesImpl() {
    }

    public FilesImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
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
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilesImpl)) {
            return false;
        }
        FilesImpl other = (FilesImpl) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Files[ name=" + name + " ]";
    }

}

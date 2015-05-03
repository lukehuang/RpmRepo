/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "conflicts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conflicts.findAll", query = "SELECT c FROM Conflicts c"),
    @NamedQuery(name = "Conflicts.findByName", query = "SELECT c FROM Conflicts c WHERE c.name = :name"),
    @NamedQuery(name = "Conflicts.findByFlags", query = "SELECT c FROM Conflicts c WHERE c.flags = :flags"),
    @NamedQuery(name = "Conflicts.findByEpoch", query = "SELECT c FROM Conflicts c WHERE c.epoch = :epoch"),
    @NamedQuery(name = "Conflicts.findByVersion", query = "SELECT c FROM Conflicts c WHERE c.version = :version"),
    @NamedQuery(name = "Conflicts.findByRelease", query = "SELECT c FROM Conflicts c WHERE c.release = :release")})
public class Conflicts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "flags")
    private String flags;
    @Column(name = "epoch")
    private String epoch;
    @Column(name = "version")
    private String version;
    @Column(name = "release")
    private String release;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgKey")
    @ManyToOne
    private Packages pkgKey;

    public Conflicts() {
    }

    public Conflicts(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
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
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conflicts)) {
            return false;
        }
        Conflicts other = (Conflicts) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Conflicts[ name=" + name + " ]";
    }

}

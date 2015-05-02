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
import ua.pp.msk.yum.sqlite.Packages;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Entity
@Table(name = "recommends")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recommends.findAll", query = "SELECT r FROM Recommends r"),
    @NamedQuery(name = "Recommends.findByName", query = "SELECT r FROM Recommends r WHERE r.name = :name"),
    @NamedQuery(name = "Recommends.findByFlags", query = "SELECT r FROM Recommends r WHERE r.flags = :flags"),
    @NamedQuery(name = "Recommends.findByEpoch", query = "SELECT r FROM Recommends r WHERE r.epoch = :epoch"),
    @NamedQuery(name = "Recommends.findByVersion", query = "SELECT r FROM Recommends r WHERE r.version = :version"),
    @NamedQuery(name = "Recommends.findByRelease", query = "SELECT r FROM Recommends r WHERE r.release = :release")})
public class Recommends implements Serializable {
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
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgId")
    @ManyToOne
    private Packages pkgKey;

    public Recommends() {
    }

    public Recommends(String name) {
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
        if (!(object instanceof Recommends)) {
            return false;
        }
        Recommends other = (Recommends) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Recommends[ name=" + name + " ]";
    }

}

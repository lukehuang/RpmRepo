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
@Table(name = "suggests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suggests.findAll", query = "SELECT s FROM Suggests s"),
    @NamedQuery(name = "Suggests.findByName", query = "SELECT s FROM Suggests s WHERE s.name = :name"),
    @NamedQuery(name = "Suggests.findByFlags", query = "SELECT s FROM Suggests s WHERE s.flags = :flags"),
    @NamedQuery(name = "Suggests.findByEpoch", query = "SELECT s FROM Suggests s WHERE s.epoch = :epoch"),
    @NamedQuery(name = "Suggests.findByVersion", query = "SELECT s FROM Suggests s WHERE s.version = :version"),
    @NamedQuery(name = "Suggests.findByRelease", query = "SELECT s FROM Suggests s WHERE s.release = :release")})
public class Suggests implements Serializable {
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

    public Suggests() {
    }

    public Suggests(String name) {
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
        if (!(object instanceof Suggests)) {
            return false;
        }
        Suggests other = (Suggests) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Suggests[ name=" + name + " ]";
    }

}

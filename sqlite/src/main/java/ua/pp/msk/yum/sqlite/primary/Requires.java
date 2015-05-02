/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.primary;

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
import ua.pp.msk.yum.sqlite.Packages;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Entity
@Table(name = "requires")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requires.findAll", query = "SELECT r FROM Requires r"),
    @NamedQuery(name = "Requires.findByName", query = "SELECT r FROM Requires r WHERE r.requires1PK.name = :name"),
    @NamedQuery(name = "Requires.findByFlags", query = "SELECT r FROM Requires r WHERE r.flags = :flags"),
    @NamedQuery(name = "Requires.findByEpoch", query = "SELECT r FROM Requires r WHERE r.requires1PK.epoch = :epoch"),
    @NamedQuery(name = "Requires.findByVersion", query = "SELECT r FROM Requires r WHERE r.requires1PK.version = :version"),
    @NamedQuery(name = "Requires.findByRelease", query = "SELECT r FROM Requires r WHERE r.requires1PK.release = :release"),
    @NamedQuery(name = "Requires.findByPre", query = "SELECT r FROM Requires r WHERE r.pre = :pre")})
public class Requires implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequiresPK requires1PK;
    @Column(name = "flags")
    private String flags;
    @Column(name = "pre")
    private Integer pre;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgId")
    @ManyToOne
    private Packages pkgKey;

    public Requires() {
    }

    public Requires(RequiresPK requires1PK) {
        this.requires1PK = requires1PK;
    }

    public Requires(String name, String epoch, String version, String release) {
        this.requires1PK = new RequiresPK(name, epoch, version, release);
    }

    public RequiresPK getRequiresPK() {
        return requires1PK;
    }

    public void setRequiresPK(RequiresPK requires1PK) {
        this.requires1PK = requires1PK;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public Integer getPre() {
        return pre;
    }

    public void setPre(Integer pre) {
        this.pre = pre;
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
        hash += (requires1PK != null ? requires1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requires)) {
            return false;
        }
        Requires other = (Requires) object;
        if ((this.requires1PK == null && other.requires1PK != null) || (this.requires1PK != null && !this.requires1PK.equals(other.requires1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Requires[ requires1PK=" + requires1PK + " ]";
    }

}

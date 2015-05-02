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
@Table(name = "supplements1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplements1.findAll", query = "SELECT s FROM Supplements1 s"),
    @NamedQuery(name = "Supplements1.findByName", query = "SELECT s FROM Supplements1 s WHERE s.supplements1PK.name = :name"),
    @NamedQuery(name = "Supplements1.findByFlags", query = "SELECT s FROM Supplements1 s WHERE s.flags = :flags"),
    @NamedQuery(name = "Supplements1.findByEpoch", query = "SELECT s FROM Supplements1 s WHERE s.supplements1PK.epoch = :epoch"),
    @NamedQuery(name = "Supplements1.findByVersion", query = "SELECT s FROM Supplements1 s WHERE s.supplements1PK.version = :version"),
    @NamedQuery(name = "Supplements1.findByRelease", query = "SELECT s FROM Supplements1 s WHERE s.supplements1PK.release = :release")})
public class Supplements implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SupplementsPK supplements1PK;
    @Column(name = "flags")
    private String flags;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgId")
    @ManyToOne
    private Packages pkgKey;

    public Supplements() {
    }

    public Supplements(SupplementsPK supplements1PK) {
        this.supplements1PK = supplements1PK;
    }

    public Supplements(String name, String epoch, String version, String release) {
        this.supplements1PK = new SupplementsPK(name, epoch, version, release);
    }

    public SupplementsPK getSupplements1PK() {
        return supplements1PK;
    }

    public void setSupplements1PK(SupplementsPK supplements1PK) {
        this.supplements1PK = supplements1PK;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
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
        hash += (supplements1PK != null ? supplements1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplements)) {
            return false;
        }
        Supplements other = (Supplements) object;
        if ((this.supplements1PK == null && other.supplements1PK != null) || (this.supplements1PK != null && !this.supplements1PK.equals(other.supplements1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Supplements1[ supplements1PK=" + supplements1PK + " ]";
    }

}

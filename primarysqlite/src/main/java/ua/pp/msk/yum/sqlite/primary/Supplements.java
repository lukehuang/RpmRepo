/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import ua.pp.msk.yum.sqlite.common.AbstractEntry;
import ua.pp.msk.yum.sqlite.common.Entry;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Entity
@Table(name = "supplements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplements.findAll", query = "SELECT s FROM Supplements s"),
    @NamedQuery(name = "Supplements.findByName", query = "SELECT s FROM Supplements s WHERE s.supplementsPK.name = :name"),
    @NamedQuery(name = "Supplements.findByFlags", query = "SELECT s FROM Supplements s WHERE s.flags = :flags"),
    @NamedQuery(name = "Supplements.findByEpoch", query = "SELECT s FROM Supplements s WHERE s.supplementsPK.epoch = :epoch"),
    @NamedQuery(name = "Supplements.findByVersion", query = "SELECT s FROM Supplements s WHERE s.supplementsPK.version = :version"),
    @NamedQuery(name = "Supplements.findByRelease", query = "SELECT s FROM Supplements s WHERE s.supplementsPK.release = :release")})
public class Supplements extends AbstractEntry implements Serializable {
    private static final long serialVersionUID = 1L;
        @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Embedded
    protected EntryPK supplementsPK;
    @Column(name = "flags")
    private String flags;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgKey")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Packages pkgKey;

    public Supplements() {
        supplementsPK = new EntryPK();
    }

    public Supplements(EntryPK supplements1PK) {
        this.supplementsPK = supplements1PK;
    }

    public Supplements(String name, String epoch, String version, String release) {
        this.supplementsPK = new EntryPK(name, epoch, version, release);
    }
    public Supplements(Entry entry){
       this(new EntryPK(entry));
    }
    public EntryPK getSupplementsPK() {
        return supplementsPK;
    }

    public void setSupplementsPK(EntryPK supplementsPK) {
        this.supplementsPK = supplementsPK;
    }

    @Override
    public String getFlags() {
        return flags;
    }

    @Override
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
        hash += (supplementsPK != null ? supplementsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplements)) {
            return false;
        }
        Supplements other = (Supplements) object;
        if ((this.supplementsPK == null && other.supplementsPK != null) || (this.supplementsPK != null && !this.supplementsPK.equals(other.supplementsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Supplements[ supplements1PK=" + supplementsPK + " ]";
    }

    @Override
    public String getName() {
        return supplementsPK.getName();
    }

    @Override
    public void setName(String name) {
        supplementsPK.setName(name);
    }

    @Override
    public String getEpoch() {
        return supplementsPK.getEpoch();
    }

    @Override
    public void setEpoch(String epoch) {
        supplementsPK.setEpoch(epoch);
    }

    @Override
    public String getVersion() {
        return supplementsPK.getVersion();
    }

    @Override
    public void setVersion(String version) {
        supplementsPK.setVersion(version);
    }

    @Override
    public String getRelease() {
        return supplementsPK.getRelease();
    }

    @Override
    public void setRelease(String release) {
        supplementsPK.setRelease(release);
    }

}

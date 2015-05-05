/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "enhances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enhances.findAll", query = "SELECT e FROM Enhances e"),
    @NamedQuery(name = "Enhances.findByName", query = "SELECT e FROM Enhances e WHERE e.enhancesPK.name = :name"),
    @NamedQuery(name = "Enhances.findByFlags", query = "SELECT e FROM Enhances e WHERE e.flags = :flags"),
    @NamedQuery(name = "Enhances.findByEpoch", query = "SELECT e FROM Enhances e WHERE e.enhancesPK.epoch = :epoch"),
    @NamedQuery(name = "Enhances.findByVersion", query = "SELECT e FROM Enhances e WHERE e.enhancesPK.version = :version"),
    @NamedQuery(name = "Enhances.findByRelease", query = "SELECT e FROM Enhances e WHERE e.enhancesPK.release = :release")})
public class Enhances extends AbstractEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntryPK enhancesPK;
    @Column(name = "flags")
    private String flags;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgId")
    @ManyToOne
    private Packages pkgKey;

    public Enhances() {
    }

    public Enhances(EntryPK name) {
        this.enhancesPK = name;
    }

    public Enhances(Entry entry) {
        this(new EntryPK(entry));
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
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Enhances[ name=" + enhancesPK + " ]";
    }

    @Override
    public String getName() {
        return enhancesPK.getName();
    }

    @Override
    public void setName(String name) {
        enhancesPK.setName(name);
    }

    @Override
    public String getEpoch() {
        return enhancesPK.getEpoch();
    }

    @Override
    public void setEpoch(String epoch) {
        enhancesPK.setEpoch(epoch);
    }

    @Override
    public String getVersion() {
        return enhancesPK.getVersion();
    }

    @Override
    public void setVersion(String version) {
        enhancesPK.setVersion(version);
    }

    @Override
    public String getRelease() {
        return enhancesPK.getRelease();
    }

    @Override
    public void setRelease(String release) {
        enhancesPK.setRelease(release);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.enhancesPK);
        hash = 83 * hash + Objects.hashCode(this.pkgKey);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Provides other = (Provides) obj;
        if (!Objects.equals(this.enhancesPK, other.providesPK)) {
            return false;
        }
        return true;
    }

}

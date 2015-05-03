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
public class Conflicts implements Entry {
    private static final long serialVersionUID = 1L;
     @EmbeddedId
    protected EntryPK conflictsPK;
   
    @Column(name = "flags")
    private String flags;
   
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgKey")
    @ManyToOne
    private Packages pkgKey;

    public Conflicts() {
    }

    public Conflicts(EntryPK pk) {
        this.conflictsPK = pk;
    }

    @Override
    public String getName() {
        return conflictsPK.getName();
    }

    @Override
    public void setName(String name) {
         conflictsPK.setName(name);
    }

    @Override
    public String getFlags() {
        return flags;
    }

    @Override
    public void setFlags(String flags) {
        this.flags = flags;
    }

    @Override
    public String getEpoch() {
        return conflictsPK.getEpoch();
    }

    @Override
    public void setEpoch(String epoch) {
        this.conflictsPK.setEpoch(epoch);
    }

    @Override
    public String getVersion() {
        return conflictsPK.getVersion();
    }

    @Override
    public void setVersion(String version) {
        this.conflictsPK.setVersion(version);
    }

    @Override
    public String getRelease() {
        return conflictsPK.getRelease();
    }

    @Override
    public void setRelease(String release) {
        this.conflictsPK.setRelease(release);
    }

    public Packages getPkgKey() {
        return pkgKey;
    }

    public void setPkgKey(Packages pkgKey) {
        this.pkgKey = pkgKey;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.conflictsPK);
        hash = 59 * hash + Objects.hashCode(this.pkgKey);
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
        final Conflicts other = (Conflicts) obj;
        if (!Objects.equals(this.conflictsPK, other.conflictsPK)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Conflicts[ name=" + conflictsPK + " ]";
    }

}

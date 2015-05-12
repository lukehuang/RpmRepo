/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
@Table(name = "conflicts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conflicts.findAll", query = "SELECT c FROM Conflicts c"),
    @NamedQuery(name = "Conflicts.findByName", query = "SELECT c FROM Conflicts c WHERE c.conflictsPK.name = :name"),
    @NamedQuery(name = "Conflicts.findByFlags", query = "SELECT c FROM Conflicts c WHERE c.flags = :flags"),
    @NamedQuery(name = "Conflicts.findByEpoch", query = "SELECT c FROM Conflicts c WHERE c.conflictsPK.epoch = :epoch"),
    @NamedQuery(name = "Conflicts.findByVersion", query = "SELECT c FROM Conflicts c WHERE c.conflictsPK.version = :version"),
    @NamedQuery(name = "Conflicts.findByRelease", query = "SELECT c FROM Conflicts c WHERE c.conflictsPK.release = :release")})
public class Conflicts extends AbstractEntry implements Serializable{
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
    protected EntryPK conflictsPK;
   
    @Column(name = "flags")
    private String flags;
   
   
    @JoinColumn(name = "pkgKey",referencedColumnName = "pkgId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne
    private Packages pkgKey;

    public Conflicts() {
        conflictsPK = new EntryPK();
    }

    public Conflicts(EntryPK pk) {
        this.conflictsPK = pk;
    }
    
    public Conflicts(Entry entry){
       this(new EntryPK(entry));
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

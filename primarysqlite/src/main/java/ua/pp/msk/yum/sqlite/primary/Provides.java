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
@Table(name = "provides")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provides.findAll", query = "SELECT p FROM Provides p"),
    @NamedQuery(name = "Provides.findByName", query = "SELECT p FROM Provides p WHERE p.providesPK.name = :name"),
    @NamedQuery(name = "Provides.findByFlags", query = "SELECT p FROM Provides p WHERE p.flags = :flags"),
    @NamedQuery(name = "Provides.findByEpoch", query = "SELECT p FROM Provides p WHERE p.providesPK.epoch = :epoch"),
    @NamedQuery(name = "Provides.findByVersion", query = "SELECT p FROM Provides p WHERE p.providesPK.version = :version"),
    @NamedQuery(name = "Provides.findByRelease", query = "SELECT p FROM Provides p WHERE p.providesPK.release = :release")})
public class Provides extends AbstractEntry implements Serializable {
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
    protected EntryPK providesPK;
    @Column(name = "flags")
    private String flags;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgKey")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Packages pkgKey;

    public Provides() {
        providesPK = new EntryPK();
    }
    public Provides(Entry entry){
       this(new EntryPK(entry));
    }
    public Provides(EntryPK epk) {
        this.providesPK = epk;
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
    public String getName() {
        return providesPK.getName();
    }

    @Override
    public void setName(String name) {
        providesPK.setName(name);
    }

    @Override
    public String getEpoch() {
        return providesPK.getEpoch();
    }

    @Override
    public void setEpoch(String epoch) {
        providesPK.setEpoch(epoch);
        }

    @Override
    public String getVersion() {
        return providesPK.getVersion();
    }

    @Override
    public void setVersion(String version) {
        providesPK.setVersion(version);
    }

    @Override
    public String getRelease() {
        return providesPK.getRelease();
    }

    @Override
    public void setRelease(String release) {
        providesPK.setRelease(release);
    }

    public Packages getPkgKey() {
        return pkgKey;
    }

    public void setPkgKey(Packages pkgKey) {
        this.pkgKey = pkgKey;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.providesPK);
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
        if (!Objects.equals(this.providesPK, other.providesPK)) {
            return false;
        }
        return true;
    }

 

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Provides[ name=" + providesPK + " ]";
    }

}

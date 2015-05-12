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
@Table(name = "obsoletes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obsoletes.findAll", query = "SELECT o FROM Obsoletes o"),
    @NamedQuery(name = "Obsoletes.findByName", query = "SELECT o FROM Obsoletes o WHERE o.obsoletesPK.name = :name"),
    @NamedQuery(name = "Obsoletes.findByFlags", query = "SELECT o FROM Obsoletes o WHERE o.flags = :flags"),
    @NamedQuery(name = "Obsoletes.findByEpoch", query = "SELECT o FROM Obsoletes o WHERE o.obsoletesPK.epoch = :epoch"),
    @NamedQuery(name = "Obsoletes.findByVersion", query = "SELECT o FROM Obsoletes o WHERE o.obsoletesPK.version = :version"),
    @NamedQuery(name = "Obsoletes.findByRelease", query = "SELECT o FROM Obsoletes o WHERE o.obsoletesPK.release = :release")})
public class Obsoletes extends AbstractEntry implements Serializable {
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
    protected EntryPK obsoletesPK;
    @Column(name = "flags")
    private String flags;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgKey")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Packages pkgKey;

    public Obsoletes() {
        obsoletesPK = new EntryPK();
    }
    public Obsoletes(Entry entry){
       this(new EntryPK(entry));
    }
    public Obsoletes(EntryPK name) {
        this.obsoletesPK = name;
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
        return "ua.pp.msk.yum.sqlite.primary.Obsoletes[ name=" + obsoletesPK + " ]";
    }
   @Override
    public String getName() {
        return obsoletesPK.getName();
    }

    @Override
    public void setName(String name) {
        obsoletesPK.setName(name);
    }

    @Override
    public String getEpoch() {
        return obsoletesPK.getEpoch();
    }

    @Override
    public void setEpoch(String epoch) {
        obsoletesPK.setEpoch(epoch);
        }

    @Override
    public String getVersion() {
        return obsoletesPK.getVersion();
    }

    @Override
    public void setVersion(String version) {
        obsoletesPK.setVersion(version);
    }

    @Override
    public String getRelease() {
        return obsoletesPK.getRelease();
    }

    @Override
    public void setRelease(String release) {
        obsoletesPK.setRelease(release);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.obsoletesPK);
        hash = 97 * hash + Objects.hashCode(this.pkgKey);
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
        final Obsoletes other = (Obsoletes) obj;
        if (!Objects.equals(this.obsoletesPK, other.obsoletesPK)) {
            return false;
        }
        return true;
    }
    
    
}

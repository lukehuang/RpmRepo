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
import ua.pp.msk.yum.sqlite.common.AbstractEntry;
import ua.pp.msk.yum.sqlite.common.Entry;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Entity
@Table(name = "suggests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suggests.findAll", query = "SELECT s FROM Suggests s"),
    @NamedQuery(name = "Suggests.findByName", query = "SELECT s FROM Suggests s WHERE s.suggestsPK.name = :name"),
    @NamedQuery(name = "Suggests.findByFlags", query = "SELECT s FROM Suggests s WHERE s.flags = :flags"),
    @NamedQuery(name = "Suggests.findByEpoch", query = "SELECT s FROM Suggests s WHERE s.suggestsPK.epoch = :epoch"),
    @NamedQuery(name = "Suggests.findByVersion", query = "SELECT s FROM Suggests s WHERE s.suggestsPK.version = :version"),
    @NamedQuery(name = "Suggests.findByRelease", query = "SELECT s FROM Suggests s WHERE s.suggestsPK.release = :release")})
public class Suggests extends AbstractEntry implements Serializable {
    private static final long serialVersionUID = 1L;
 @EmbeddedId
    protected EntryPK suggestsPK;
    @Column(name = "flags")
    private String flags;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgKey")
    @ManyToOne
    private Packages pkgKey;

    public Suggests() {
        suggestsPK = new EntryPK();
    }
    public Suggests(String name, String epoch, String version, String release) {
        this.suggestsPK = new EntryPK(name, epoch, version, release);
    }
    public Suggests(EntryPK name) {
        this.suggestsPK = name;
    }
    public Suggests(Entry entry){
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
        return "ua.pp.msk.yum.sqlite.primary.Suggests[ name=" + suggestsPK + " ]";
    }

       @Override
    public int hashCode() {
        int hash = 0;
        hash += (suggestsPK != null ? suggestsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requires)) {
            return false;
        }
        Requires other = (Requires) object;
        if ((this.suggestsPK == null && other.requiresPK != null) || (this.suggestsPK != null && !this.suggestsPK.equals(other.requiresPK))) {
            return false;
        }
        return true;
    }

   

    @Override
    public String getName() {
        return suggestsPK.getName();
    }

    @Override
    public void setName(String name) {
        suggestsPK.setName(name);
    }

    @Override
    public String getEpoch() {
        return suggestsPK.getEpoch();
    }

    @Override
    public void setEpoch(String epoch) {
        suggestsPK.setEpoch(epoch);
        }

    @Override
    public String getVersion() {
        return suggestsPK.getVersion();
    }

    @Override
    public void setVersion(String version) {
        suggestsPK.setVersion(version);
    }

    @Override
    public String getRelease() {
        return suggestsPK.getRelease();
    }

    @Override
    public void setRelease(String release) {
        suggestsPK.setRelease(release);
    }

}

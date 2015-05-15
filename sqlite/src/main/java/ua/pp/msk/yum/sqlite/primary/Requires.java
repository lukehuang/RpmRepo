/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import ua.pp.msk.yum.sqlite.common.AbstractEntry;
import ua.pp.msk.yum.sqlite.common.Entry;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@XmlRootElement

public class Requires extends AbstractEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    protected EntryPK requiresPK;
    private String flags;
    private boolean pre;
    private Packages pkgKey;

    public Requires() {
        requiresPK = new EntryPK();
    }
    public Requires(Entry entry){
       this(new EntryPK(entry));
    }
    public Requires(EntryPK requiresPK) {
        this.requiresPK = requiresPK;
    }

    public Requires(String name, String epoch, String version, String release) {
        this.requiresPK = new EntryPK(name, epoch, version, release);
    }

    public EntryPK getRequiresPK() {
        return requiresPK;
    }

    public void setRequiresPK(EntryPK requires1PK) {
        this.requiresPK = requires1PK;
    }

    @Override
    public String getFlags() {
        return flags;
    }

    @Override
    public void setFlags(String flags) {
        this.flags = flags;
    }

    public boolean getPre() {
        return pre;
    }

    public void setPre(boolean pre) {
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
        hash += (requiresPK != null ? requiresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requires)) {
            return false;
        }
        Requires other = (Requires) object;
        if ((this.requiresPK == null && other.requiresPK != null) || (this.requiresPK != null && !this.requiresPK.equals(other.requiresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Requires[ requires1PK=" + requiresPK + " ]";
    }

    @Override
    public String getName() {
        return requiresPK.getName();
    }

    @Override
    public void setName(String name) {
        requiresPK.setName(name);
    }

    @Override
    public String getEpoch() {
        return requiresPK.getEpoch();
    }

    @Override
    public void setEpoch(String epoch) {
        requiresPK.setEpoch(epoch);
        }

    @Override
    public String getVersion() {
        return requiresPK.getVersion();
    }

    @Override
    public void setVersion(String version) {
        requiresPK.setVersion(version);
    }

    @Override
    public String getRelease() {
        return requiresPK.getRelease();
    }

    @Override
    public void setRelease(String release) {
        requiresPK.setRelease(release);
    }

}

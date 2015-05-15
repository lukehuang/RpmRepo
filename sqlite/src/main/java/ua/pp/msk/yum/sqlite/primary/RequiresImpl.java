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

public class RequiresImpl extends AbstractEntry implements Requires {
    private static final long serialVersionUID = 1L;
    private long id;
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
    protected EntryPK requiresPK;
    private String flags;
    private boolean pre;
    private PackagesImpl pkgKey;

    public RequiresImpl() {
        requiresPK = new EntryPK();
    }
    public RequiresImpl(Entry entry){
       this(new EntryPK(entry));
    }
    public RequiresImpl(EntryPK requiresPK) {
        this.requiresPK = requiresPK;
    }

    public RequiresImpl(String name, String epoch, String version, String release) {
        this.requiresPK = new EntryPK(name, epoch, version, release);
    }

    @Override
    public EntryPK getRequiresPK() {
        return requiresPK;
    }

    @Override
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

    @Override
    public boolean getPre() {
        return pre;
    }

    @Override
    public void setPre(boolean pre) {
        this.pre = pre;
    }

    @Override
    public PackagesImpl getPkgKey() {
        return pkgKey;
    }

    @Override
    public void setPkgKey(PackagesImpl pkgKey) {
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
        if (!(object instanceof RequiresImpl)) {
            return false;
        }
        RequiresImpl other = (RequiresImpl) object;
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

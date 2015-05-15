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

public class SupplementsImpl extends AbstractEntry implements Supplements {
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
    protected EntryPK supplementsPK;
    private String flags;
    private PackagesImpl pkgKey;

    public SupplementsImpl() {
        supplementsPK = new EntryPK();
    }

    public SupplementsImpl(EntryPK supplements1PK) {
        this.supplementsPK = supplements1PK;
    }

    public SupplementsImpl(String name, String epoch, String version, String release) {
        this.supplementsPK = new EntryPK(name, epoch, version, release);
    }
    public SupplementsImpl(Entry entry){
       this(new EntryPK(entry));
    }
    @Override
    public EntryPK getSupplementsPK() {
        return supplementsPK;
    }

    @Override
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
        hash += (supplementsPK != null ? supplementsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplementsImpl)) {
            return false;
        }
        SupplementsImpl other = (SupplementsImpl) object;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import ua.pp.msk.yum.sqlite.common.AbstractEntry;
import ua.pp.msk.yum.sqlite.common.Entry;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@XmlRootElement

public class ProvidesImpl extends AbstractEntry implements Provides {
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
    protected EntryPK providesPK;
    private String flags;
    private PackagesImpl pkgKey;

    public ProvidesImpl() {
        providesPK = new EntryPK();
    }
    public ProvidesImpl(Entry entry){
       this(new EntryPK(entry));
    }
    public ProvidesImpl(EntryPK epk) {
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
        final ProvidesImpl other = (ProvidesImpl) obj;
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

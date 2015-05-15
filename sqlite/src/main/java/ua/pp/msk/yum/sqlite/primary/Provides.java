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

public class Provides extends AbstractEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    protected EntryPK providesPK;
    private String flags;
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

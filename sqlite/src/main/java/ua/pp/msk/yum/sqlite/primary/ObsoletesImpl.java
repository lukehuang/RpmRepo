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
public class ObsoletesImpl extends AbstractEntry implements Obsoletes {
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
    protected EntryPK obsoletesPK;
    private String flags;
    private PackagesImpl pkgKey;

    public ObsoletesImpl() {
        obsoletesPK = new EntryPK();
    }
    public ObsoletesImpl(Entry entry){
       this(new EntryPK(entry));
    }
    public ObsoletesImpl(EntryPK name) {
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

   

    @Override
    public PackagesImpl getPkgKey() {
        return pkgKey;
    }

    @Override
    public void setPkgKey(PackagesImpl pkgKey) {
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
        final ObsoletesImpl other = (ObsoletesImpl) obj;
        if (!Objects.equals(this.obsoletesPK, other.obsoletesPK)) {
            return false;
        }
        return true;
    }
    
    
}

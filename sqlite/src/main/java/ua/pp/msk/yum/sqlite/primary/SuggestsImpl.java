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
    
public class SuggestsImpl extends AbstractEntry implements Suggests {
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
    protected EntryPK suggestsPK;
    private String flags;
    private PackagesImpl pkgKey;

    public SuggestsImpl() {
        suggestsPK = new EntryPK();
    }
    public SuggestsImpl(String name, String epoch, String version, String release) {
        this.suggestsPK = new EntryPK(name, epoch, version, release);
    }
    public SuggestsImpl(EntryPK name) {
        this.suggestsPK = name;
    }
    public SuggestsImpl(Entry entry){
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
        if (!(object instanceof RequiresImpl)) {
            return false;
        }
        RequiresImpl other = (RequiresImpl) object;
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

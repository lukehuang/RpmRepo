/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import java.util.Objects;
import ua.pp.msk.yum.sqlite.common.AbstractEntry;
import ua.pp.msk.yum.sqlite.common.Entry;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class Conflicts extends AbstractEntry implements Serializable{
    private static final long serialVersionUID = 1L;
    private long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    protected EntryPK conflictsPK;
   
    private String flags;
   
   
    private Packages pkgKey;

    public Conflicts() {
        conflictsPK = new EntryPK();
    }

    public Conflicts(EntryPK pk) {
        this.conflictsPK = pk;
    }
    
    public Conflicts(Entry entry){
       this(new EntryPK(entry));
    }

    
    
    public String getName() {
        return conflictsPK.getName();
    }

    public void setName(String name) {
         conflictsPK.setName(name);
    }

    public String getFlags() {
        return flags;
    }

    @Override
    public void setFlags(String flags) {
        this.flags = flags;
    }

    @Override
    public String getEpoch() {
        return conflictsPK.getEpoch();
    }

    @Override
    public void setEpoch(String epoch) {
        this.conflictsPK.setEpoch(epoch);
    }

    @Override
    public String getVersion() {
        return conflictsPK.getVersion();
    }

    @Override
    public void setVersion(String version) {
        this.conflictsPK.setVersion(version);
    }

    @Override
    public String getRelease() {
        return conflictsPK.getRelease();
    }

    @Override
    public void setRelease(String release) {
        this.conflictsPK.setRelease(release);
    }

    public Packages getPkgKey() {
        return pkgKey;
    }

    public void setPkgKey(Packages pkgKey) {
        this.pkgKey = pkgKey;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.conflictsPK);
        hash = 59 * hash + Objects.hashCode(this.pkgKey);
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
        final Conflicts other = (Conflicts) obj;
        if (!Objects.equals(this.conflictsPK, other.conflictsPK)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Conflicts[ name=" + conflictsPK + " ]";
    }

}

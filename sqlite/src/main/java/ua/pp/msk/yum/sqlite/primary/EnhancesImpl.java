/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary;

import java.util.Objects;
import ua.pp.msk.yum.sqlite.common.AbstractEntry;
import ua.pp.msk.yum.sqlite.common.Enhances;
import ua.pp.msk.yum.sqlite.common.Entry;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */


public class EnhancesImpl extends AbstractEntry implements Enhances {
    private static final long serialVersionUID = 1L;
   
    private String name;
    private String flags;
    private String epoch;
    private String version;
    private String release;
    private int pkgKey;
    
    
    public EnhancesImpl() {}
    
    public EnhancesImpl(String name, String flags, String epoch, String version, String release) {
        this.name = name;
        this.flags = flags;
        this.epoch = epoch;
        this.version = version;
        this.release = release;
    }
    public EnhancesImpl(Entry entry){
      this(entry.getName(), entry.getFlags(), entry.getEpoch(), entry.getVersion(), entry.getRelease());
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
    public int getPkgKey() {
        return pkgKey;
    }

 
    @Override
    public void setPkgKey(int pkgKey) {
        this.pkgKey = pkgKey;
    }

    @Override
    public String toString() {
        return "EnhancesImpl{" + "name=" + name + ", flags=" + flags + ", epoch=" + epoch + ", version=" + version + ", release=" + release + ", pkgKey=" + pkgKey + '}';
    }

   

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEpoch() {
        return epoch;
    }

    @Override
    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String getRelease() {
        return release;
    }

    @Override
    public void setRelease(String release) {
        this.release = release;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.flags);
        hash = 47 * hash + Objects.hashCode(this.epoch);
        hash = 47 * hash + Objects.hashCode(this.version);
        hash = 47 * hash + Objects.hashCode(this.release);
        hash = 47 * hash + this.pkgKey;
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
        final EnhancesImpl other = (EnhancesImpl) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.flags, other.flags)) {
            return false;
        }
        if (!Objects.equals(this.epoch, other.epoch)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        if (!Objects.equals(this.release, other.release)) {
            return false;
        }
        return true;
    }


}

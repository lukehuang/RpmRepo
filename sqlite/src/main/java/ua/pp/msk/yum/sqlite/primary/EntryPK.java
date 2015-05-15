/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import ua.pp.msk.yum.sqlite.common.Entry;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class EntryPK implements Serializable {
    private String name;
    private String epoch;
    private String version;
    private String release;

    public EntryPK() {
    }

    public EntryPK(String name, String epoch, String version, String release) {
        this.name = name;
        this.epoch = epoch;
        this.version = version;
        this.release = release;
    }

    public EntryPK(Entry e){
        this(e.getName(), e.getEpoch(), e.getVersion(), e.getRelease());
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        hash += (epoch != null ? epoch.hashCode() : 0);
        hash += (version != null ? version.hashCode() : 0);
        hash += (release != null ? release.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntryPK)) {
            return false;
        }
        EntryPK other = (EntryPK) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        if ((this.epoch == null && other.epoch != null) || (this.epoch != null && !this.epoch.equals(other.epoch))) {
            return false;
        }
        if ((this.version == null && other.version != null) || (this.version != null && !this.version.equals(other.version))) {
            return false;
        }
        if ((this.release == null && other.release != null) || (this.release != null && !this.release.equals(other.release))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Embedded Entry [ name=" + name + ", epoch=" + epoch + ", version=" + version + ", release=" + release + " ]";
    }

}

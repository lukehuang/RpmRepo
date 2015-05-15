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
public class Recommends extends AbstractEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    protected EntryPK recommendsPK;
    private String flags;
    private Packages pkgKey;

    public Recommends() {
        recommendsPK = new EntryPK();
    }

    public Recommends(String name, String epoch, String version, String release) {
        this.recommendsPK = new EntryPK(name, epoch, version, release);
    }

    public Recommends(EntryPK epk) {
        this.recommendsPK = epk;
    }
    public Recommends(Entry entry){
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

    public Packages getPkgKey() {
        return pkgKey;
    }

    public void setPkgKey(Packages pkgKey) {
        this.pkgKey = pkgKey;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Recommends[ name=" + recommendsPK + " ]";
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recommendsPK != null ? recommendsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requires)) {
            return false;
        }
        Requires other = (Requires) object;
        if ((this.recommendsPK == null && other.requiresPK != null) || (this.recommendsPK != null && !this.recommendsPK.equals(other.requiresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String getName() {
        return recommendsPK.getName();
    }

    @Override
    public void setName(String name) {
        recommendsPK.setName(name);
    }

    @Override
    public String getEpoch() {
        return recommendsPK.getEpoch();
    }

    @Override
    public void setEpoch(String epoch) {
        recommendsPK.setEpoch(epoch);
    }

    @Override
    public String getVersion() {
        return recommendsPK.getVersion();
    }

    @Override
    public void setVersion(String version) {
        recommendsPK.setVersion(version);
    }

    @Override
    public String getRelease() {
        return recommendsPK.getRelease();
    }

    @Override
    public void setRelease(String release) {
        recommendsPK.setRelease(release);
    }

}

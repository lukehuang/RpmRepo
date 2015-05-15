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

public class EnhancesImpl extends AbstractEntry implements Enhances {

    private static final long serialVersionUID = 1L;
    protected EntryPK enhancesPK;
    private String flags;
    private Packages pkgKey;
    private long id;
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
    public EnhancesImpl() {
        enhancesPK = new EntryPK();
    }

    public EnhancesImpl(EntryPK name) {
        this.enhancesPK = name;
    }

    public EnhancesImpl(Entry entry) {
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
    public Packages getPkgKey() {
        return pkgKey;
    }

    @Override
    public void setPkgKey(Packages pkgKey) {
        this.pkgKey = pkgKey;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.primary.Enhances[ name=" + enhancesPK + " ]";
    }

    @Override
    public String getName() {
        return enhancesPK.getName();
    }

    @Override
    public void setName(String name) {
        enhancesPK.setName(name);
    }

    @Override
    public String getEpoch() {
        return enhancesPK.getEpoch();
    }

    @Override
    public void setEpoch(String epoch) {
        enhancesPK.setEpoch(epoch);
    }

    @Override
    public String getVersion() {
        return enhancesPK.getVersion();
    }

    @Override
    public void setVersion(String version) {
        enhancesPK.setVersion(version);
    }

    @Override
    public String getRelease() {
        return enhancesPK.getRelease();
    }

    @Override
    public void setRelease(String release) {
        enhancesPK.setRelease(release);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.enhancesPK);
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
        if (!Objects.equals(this.enhancesPK, other.providesPK)) {
            return false;
        }
        return true;
    }

}

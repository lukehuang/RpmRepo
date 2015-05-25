/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.persist;

import ua.pp.msk.yum.sqlite.common.Conflicts;
import ua.pp.msk.yum.sqlite.common.Enhances;
import ua.pp.msk.yum.sqlite.common.Obsoletes;
import ua.pp.msk.yum.sqlite.common.Provides;
import ua.pp.msk.yum.sqlite.common.Requires;
import ua.pp.msk.yum.sqlite.common.Suggests;
import ua.pp.msk.yum.sqlite.common.Supplements;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class GeneralEntry implements Conflicts, Enhances, Obsoletes, Requires, Provides, Suggests, Supplements{

    private String name;
    private String flags;
    private String release;
    private String epoch;
    private String version;
    private boolean pre;
    private int pk =-1 ;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public int getPkgKey() {
        return pk;
    }

    @Override
    public void setPkgKey(int pkgKey) {
        this.pk = pkgKey;
    }

    @Override
    public boolean getPre() {
        return pre;
    }

    @Override
    public void setPre(boolean pre) {
        this.pre = pre;
    }

}

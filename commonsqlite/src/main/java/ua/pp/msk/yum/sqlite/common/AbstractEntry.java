/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.common;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public abstract class AbstractEntry implements Entry {

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getFlags();

    public abstract void setFlags(String flags);

    public abstract String getEpoch();

    public abstract  void setEpoch(String epoch);

    public abstract String getVersion();

    public abstract void setVersion(String version);

    public abstract  String getRelease();

    public abstract  void setRelease(String release);

    
}

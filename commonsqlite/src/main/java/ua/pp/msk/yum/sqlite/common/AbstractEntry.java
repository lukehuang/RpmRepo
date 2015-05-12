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

    @Override
    public abstract String getName();

    @Override
    public abstract void setName(String name);

    @Override
    public abstract String getFlags();

    @Override
    public abstract void setFlags(String flags);

    @Override
    public abstract String getEpoch();

    @Override
    public abstract  void setEpoch(String epoch);

    @Override
    public abstract String getVersion();

    @Override
    public abstract void setVersion(String version);

    @Override
    public abstract  String getRelease();

    @Override
    public abstract  void setRelease(String release);

    
}

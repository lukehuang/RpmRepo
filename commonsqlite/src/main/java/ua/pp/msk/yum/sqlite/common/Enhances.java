/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.common;

/**
 *
 * @author edem
 */
public interface Enhances  {

    boolean equals(Object obj);

    String getEpoch();

    String getFlags();

    long getId();

    String getName();

    int getPkgKey();

    String getRelease();

    String getVersion();

    int hashCode();

    void setEpoch(String epoch);

    void setFlags(String flags);

    void setId(long id);

    void setName(String name);

    void setPkgKey(int pkgKey);

    void setRelease(String release);

    void setVersion(String version);

    String toString();
    
}

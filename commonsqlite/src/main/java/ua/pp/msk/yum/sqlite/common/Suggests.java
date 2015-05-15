/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;

/**
 *
 * @author edem
 */
public interface Suggests extends Serializable {

    boolean equals(Object object);

    String getEpoch();

    String getFlags();

    long getId();

    String getName();

    PackagesImpl getPkgKey();

    String getRelease();

    String getVersion();

    int hashCode();

    void setEpoch(String epoch);

    void setFlags(String flags);

    void setId(long id);

    void setName(String name);

    void setPkgKey(PackagesImpl pkgKey);

    void setRelease(String release);

    void setVersion(String version);

    String toString();
    
}

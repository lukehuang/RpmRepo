/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.common;

import java.io.Serializable;

/**
 *
 * @author maskimko
 */
public interface Entry extends Serializable {

    public String getName();

    public void setName(String name);

    public String getFlags();

    public void setFlags(String flags);

    public String getEpoch();

    public void setEpoch(String epoch);

    public String getVersion();

    public void setVersion(String version);

    public String getRelease();

    public void setRelease(String release);
}

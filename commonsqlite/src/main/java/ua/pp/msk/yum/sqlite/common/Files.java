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
public interface Files extends Serializable {

    boolean equals(Object object);

    String getName();

    Packages getPkgKey();

    String getType();

    int hashCode();

    void setName(String name);

    void setPkgKey(Packages pkgKey);

    void setType(String type);

    String toString();
    
}

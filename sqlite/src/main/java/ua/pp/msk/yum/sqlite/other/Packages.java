/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.other;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class Packages implements Serializable {

    private Collection<ChangelogImpl> changelogCollection;

    private static final long serialVersionUID = 1L;
    private Integer pkgKey;
    private String pkgId;

    public Packages() {
    }

    public Integer getPkgKey() {
        return pkgKey;
    }

    public void setPkgKey(Integer pkgKey) {
        this.pkgKey = pkgKey;
    }

    public String getPkgId() {
        return pkgId;
    }

    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
    }

    public Collection<ChangelogImpl> getChangelog1Collection() {
        return changelogCollection;
    }

    public void setChangelog1Collection(Collection<ChangelogImpl> changelog1Collection) {
        this.changelogCollection = changelog1Collection;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.other;

import java.io.Serializable;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class Changelog implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    protected ChangelogPK changelogPK;
    private String changelog;
    private Packages pkgKey;

    public Changelog() {
        this.changelogPK = new ChangelogPK();
    }

    public Changelog(ChangelogPK changelogPK) {
        this.changelogPK = changelogPK;
    }

    public Changelog(String author, Integer date) {
        this.changelogPK = new ChangelogPK(author, date);
    }

    public ChangelogPK getChangelogPK() {
        return changelogPK;
    }

    public void setChangelogPK(ChangelogPK changelogPK) {
        this.changelogPK = changelogPK;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }

    public Packages getPkgKey() {
        return pkgKey;
    }

    public void setPkgKey(Packages pkgKey) {
        this.pkgKey = pkgKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (changelogPK != null ? changelogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Changelog)) {
            return false;
        }
        Changelog other = (Changelog) object;
        if ((this.changelogPK == null && other.changelogPK != null) || (this.changelogPK != null && !this.changelogPK.equals(other.changelogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.other.Changelog[ changelogPK=" + changelogPK + " ]";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.other;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Entity
@Table(name = "changelog1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Changelog.findAll", query = "SELECT c FROM Changelog c"),
    @NamedQuery(name = "Changelog.findByAuthor", query = "SELECT c FROM Changelog c WHERE c.changelogPK.author = :author"),
    @NamedQuery(name = "Changelog.findByDate", query = "SELECT c FROM Changelog c WHERE c.changelogPK.date = :date"),
    @NamedQuery(name = "Changelog.findByChangelog", query = "SELECT c FROM Changelog c WHERE c.changelog = :changelog")})
public class Changelog implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChangelogPK changelogPK;
    @Column(name = "changelog")
    private String changelog;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgKey")
    @ManyToOne
    private Packages pkgKey;

    public Changelog() {
    }

    public Changelog(ChangelogPK changelogPK) {
        this.changelogPK = changelogPK;
    }

    public Changelog(String author, Integer date) {
        this.changelogPK = new ChangelogPK(author, date);
    }

    public ChangelogPK getChangelog1PK() {
        return changelogPK;
    }

    public void setChangelog1PK(ChangelogPK changelog1PK) {
        this.changelogPK = changelog1PK;
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
        return "ua.pp.msk.yum.sqlite.other.Changelog1[ changelog1PK=" + changelogPK + " ]";
    }

}

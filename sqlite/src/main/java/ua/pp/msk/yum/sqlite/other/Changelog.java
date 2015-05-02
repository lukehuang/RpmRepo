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
import ua.pp.msk.yum.sqlite.Packages;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Entity
@Table(name = "changelog1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Changelog1.findAll", query = "SELECT c FROM Changelog1 c"),
    @NamedQuery(name = "Changelog1.findByAuthor", query = "SELECT c FROM Changelog1 c WHERE c.changelog1PK.author = :author"),
    @NamedQuery(name = "Changelog1.findByDate", query = "SELECT c FROM Changelog1 c WHERE c.changelog1PK.date = :date"),
    @NamedQuery(name = "Changelog1.findByChangelog", query = "SELECT c FROM Changelog1 c WHERE c.changelog = :changelog")})
public class Changelog implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChangelogPK changelog1PK;
    @Column(name = "changelog")
    private String changelog;
    @JoinColumn(name = "pkgKey", referencedColumnName = "pkgId")
    @ManyToOne
    private Packages pkgKey;

    public Changelog() {
    }

    public Changelog(ChangelogPK changelog1PK) {
        this.changelog1PK = changelog1PK;
    }

    public Changelog(String author, Integer date) {
        this.changelog1PK = new ChangelogPK(author, date);
    }

    public ChangelogPK getChangelog1PK() {
        return changelog1PK;
    }

    public void setChangelog1PK(ChangelogPK changelog1PK) {
        this.changelog1PK = changelog1PK;
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
        hash += (changelog1PK != null ? changelog1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Changelog)) {
            return false;
        }
        Changelog other = (Changelog) object;
        if ((this.changelog1PK == null && other.changelog1PK != null) || (this.changelog1PK != null && !this.changelog1PK.equals(other.changelog1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.other.Changelog1[ changelog1PK=" + changelog1PK + " ]";
    }

}

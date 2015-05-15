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
public class ChangelogPK implements Serializable {
    private String author;
    private Integer date;

    public ChangelogPK() {
    }

    public ChangelogPK(String author, Integer date) {
        this.author = author;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (author != null ? author.hashCode() : 0);
        hash += (date != null ? date.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChangelogPK)) {
            return false;
        }
        ChangelogPK other = (ChangelogPK) object;
        if ((this.author == null && other.author != null) || (this.author != null && !this.author.equals(other.author))) {
            return false;
        }
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.yum.sqlite.other.ChangelogPK[ author=" + author + ", date=" + date + " ]";
    }

}

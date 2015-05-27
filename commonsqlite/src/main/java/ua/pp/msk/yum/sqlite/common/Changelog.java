/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.common;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public interface Changelog extends Serializable {

    String getChangelog();

    int getPkgKey();

    void setChangelog(String changelog);

    void setPkgKey(int pkgKey);

    public String getAuthor();

    public void setAuthor(String author);

    public Integer getDate();
    public Date getDateAsDate();

    public void setDate(Integer date);
    public void setDate(Date date);

    public String getText();

    public void setText(String text);

}

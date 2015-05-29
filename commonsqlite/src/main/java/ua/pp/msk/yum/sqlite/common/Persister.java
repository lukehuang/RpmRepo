/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.common;

import java.sql.Connection;
import ua.pp.msk.yum.sqlite.common.exceptions.PersistException;

/**
 *
 * @author maskimko
 */
public interface Persister extends AutoCloseable {

    public static final String DB_INFO_TABLE="db_info";
    
    public void persist(RPM rpm) throws PersistException;
    
    public void setCompressedChecksum(String compressedChecksum) throws PersistException;
    
    public void setDbUrl(String dbUrl);

    public String getDbUrl();

    public void setUsername(String username);

    public void setPassword(String password);

    public Connection getDbCon();

}

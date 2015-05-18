/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.persist;

import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.sqlite.common.Persister;
import ua.pp.msk.yum.sqlite.common.RPM;
import ua.pp.msk.yum.sqlite.common.exceptions.PersistException;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 * @param <T> Persister class to handle storing RPM 
 */
public class AbstractPersister<T extends Persister> {
    
    private final T persister;
    
    public AbstractPersister(T persister) {
        this.persister = persister;
    }
    
    public void persist(RPM rpm) {
        try {
            synchronized(this){
                persister.persist(rpm);
            }
        } catch (PersistException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot persist RPM ", ex);
        }
        
    }
    
}

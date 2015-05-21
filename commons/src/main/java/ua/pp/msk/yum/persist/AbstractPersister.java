/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.persist;

import java.util.LinkedList;
import java.util.List;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.sqlite.common.Persister;
import ua.pp.msk.yum.sqlite.common.RPM;
import ua.pp.msk.yum.sqlite.common.exceptions.PersistException;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class AbstractPersister implements AutoCloseable {

    private final List<Persister> persisters;

    public AbstractPersister() {
        persisters = new LinkedList<>();
    }

    public AbstractPersister(Persister persister) {
        this();
        this.persisters.add(persister);
    }

    public synchronized void persist(RPM rpm) throws PersistException {
        for (Persister p : persisters) {
            p.persist(rpm);
        }

    }

    public void addPersister(Persister p) {
        persisters.add(p);
    }

    @Override
    public void close() throws Exception {
        for (Persister p : persisters){
            p.close();
        }
    }

}

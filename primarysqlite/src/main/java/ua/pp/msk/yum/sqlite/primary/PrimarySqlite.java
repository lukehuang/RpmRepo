/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class PrimarySqlite {

    public static EntityManager getEntityManger() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
        return emf.createEntityManager();
    }
}

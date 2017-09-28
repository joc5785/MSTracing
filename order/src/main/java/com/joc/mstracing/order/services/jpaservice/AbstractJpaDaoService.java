package com.joc.mstracing.order.services.jpaservice;

import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;

/**
 * Created by o'connell on 9/18/17.
 */
public class AbstractJpaDaoService {

    protected EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}

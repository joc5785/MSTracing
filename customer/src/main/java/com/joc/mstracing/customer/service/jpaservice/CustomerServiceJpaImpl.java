package com.joc.mstracing.customer.service.jpaservice;

import com.joc.mstracing.customer.domain.Customer;
import com.joc.mstracing.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * Created by o'connell on 9/19/17.
 */
@Service
public class CustomerServiceJpaImpl extends AbstractJpaDaoService implements CustomerService {

    @Override
    public List<?> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Object getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    @Override
    public Object saveOrUpdate(Object domainObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Object savedCustomer = em.merge(domainObject);
        em.getTransaction().commit();
        return savedCustomer;
    }
}

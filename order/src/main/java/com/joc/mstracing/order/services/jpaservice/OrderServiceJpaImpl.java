package com.joc.mstracing.order.services.jpaservice;

import com.joc.mstracing.order.domain.Orders;
import com.joc.mstracing.order.services.OrderService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by o'connell on 9/18/17.
 */

@Service
public class OrderServiceJpaImpl extends AbstractJpaDaoService implements OrderService {

    @Override
    public List<?> listAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from Orders", Orders.class).getResultList();
    }

    @Override
    public Object getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Orders.class, id);
    }

    @Override
    public Object saveOrUpdate(Object domainObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Object savedOrder = em.merge(domainObject);
        em.getTransaction().commit();
        return savedOrder;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Orders.class, id));
        em.getTransaction().commit();

    }
}

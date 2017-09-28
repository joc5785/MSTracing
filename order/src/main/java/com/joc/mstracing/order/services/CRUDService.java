package com.joc.mstracing.order.services;

import java.util.List;

/**
 * Created by o'connell on 9/18/17.
 */
public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);

}

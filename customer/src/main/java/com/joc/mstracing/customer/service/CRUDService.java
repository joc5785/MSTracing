package com.joc.mstracing.customer.service;

import java.util.List;

/**
 * Created by o'connell on 9/19/17.
 */
public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author pavikumbhar
 * @param <E>
 * @param <PK>

 */
public interface GenericDao<E ,PK> {
    public void add(E entity) ;
    public void saveOrUpdate(E entity) ;
    public void update(E entity) ;
    public void remove(E entity);
    public E find(PK key);
    public List<E> findAll() ;
    public List<E> findRangeOrderFirst(int beginIndex, int pageSize, String propertyName, boolean asc);
    public List<E> findRange(int beginIndex, int pageSize);
    public List<E> findPage(int pageNumber, int pageSize ) ;
}

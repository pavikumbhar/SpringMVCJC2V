/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.common.dao;

import com.pavikumbhar.javaheart.common.dao.GenericDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pavikumbhar
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {
//public class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Class<? extends E> entityType;

    /**
     * By defining this class as abstract, we prevent Spring from creating
     * instance of this class If not defined as abstract,
     * getClass().getGenericSuperClass() would return Object. There would be
     * exception because Object class does not have a constructor with
     * parameters.
     */
    
    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        entityType = (Class) pt.getActualTypeArguments()[0];
        
      
    }
     
    

     /*
    public GenericDaoImpl() {
        //Get "T" and assign it to this.entityClass
        Type genericSuperClass = getClass().getGenericSuperclass();

        ParameterizedType parametrizedType = null;
        while (parametrizedType == null) {
            if ((genericSuperClass instanceof ParameterizedType)) {
                parametrizedType = (ParameterizedType) genericSuperClass;
            } else {
                genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
            }
        }

        daoType = (Class<E>) parametrizedType.getActualTypeArguments()[0];
    }
*/
     protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
}
    @Override
    public void add(E entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(E entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void remove(E entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public E find(K key) {
        return (E) getCurrentSession().get(entityType, key);
    }

    @Override
    public List<E> findAll() {
        return getCurrentSession().createCriteria(entityType).list();
    }
    

    
     @SuppressWarnings("unchecked")
    public E get(Class c, Serializable id) {
        return (E)getCurrentSession().get(c, id);
    }
    
      /*
     * Use for pagination
     */
     @Override
    public List<E> findRange(int beginIndex, int pageSize) {
        Criteria criteria = getCurrentSession().createCriteria(entityType);
        return findRange(criteria, beginIndex, pageSize);
    }
    
    /*
     * Use for pagination
     * Filter by Criteria
     */
    public List<E> findRange(Criteria criteria, int beginIndex, int endIndex) {
        criteria.setFirstResult(beginIndex);
        criteria.setMaxResults(endIndex-beginIndex);
        return criteria.list();
    }
    
    
     /*
     * Use for pagination but order by 'propertyName' before paging
     * Filter by criteria before paging
     */
    public List<E> findRangeOrderFirst(Criteria criteria, int beginIndex, int pageSize, String propertyName, boolean asc) {
        if( asc ) criteria.addOrder(Order.asc(propertyName));
        else criteria.addOrder(Order.desc(propertyName));
        criteria.setFirstResult(beginIndex);
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }
    
     /*
     * Use for pagination but order by 'propertyName' before paging
     */
     @Override
    public List<E> findRangeOrderFirst(int beginIndex, int pageSize, String propertyName, boolean asc) {
        Criteria criteria = getCurrentSession().createCriteria(entityType);
        return findRangeOrderFirst(criteria, beginIndex, pageSize, propertyName, asc);
    }
    
    
    /*
     * Use for pagination
     * Filter by Criteria before paging
     */
    public List<E> findPage(Criteria criteria, int pageNumber, int pageSize) {
        int beginIndex = pageNumber*pageSize;
        return findRange(criteria, beginIndex, pageSize);
    }
 
    /*
     * Use for pagination
     *
     */
     @Override
    public List<E> findPage(int pageNumber, int pageSize ) {
        int beginIndex = pageNumber*pageSize;
        return findRange(beginIndex, pageSize);
    }
 
    
    
 
}

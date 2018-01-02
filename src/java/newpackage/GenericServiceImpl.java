/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
/**
 *
 * @author pavikumbhar
 */
public class GenericServiceImpl<T, D, ID extends Serializable> implements GenericService<T, D, ID> {
    
    protected Class<T> entityClass;

    protected Class<D> dtoClass;

    @SuppressWarnings("unchecked")
    public GenericServiceImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.dtoClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
    }

    @Override
    public D findOne(ID id) {
        return null; }

    @Override
    public List<D> findAll() {
          return null; 
    }

    @Override
    public void save(D dto) {
    
    }

    
}

package com.pavikumbhar.javaheart.common.V2;


import com.pavikumbhar.javaheart.common.V2.ServiceException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pavikumbhar
 */
public interface GenericService<T, PK, D> {

    T save(T entite) throws ServiceException;

    void remove(T entite) throws ServiceException;

    T findById(PK id) throws ServiceException;

    List<T> findAll() throws ServiceException;

    void removeById(PK id) throws ServiceException;

}

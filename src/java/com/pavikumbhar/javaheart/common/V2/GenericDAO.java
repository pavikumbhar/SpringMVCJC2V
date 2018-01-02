package com.pavikumbhar.javaheart.common.V2;


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
public interface GenericDAO<T, PK> {

    T save(T entite) throws DAOException;

    void remove(T entite) throws DAOException;

    T findById(PK id) throws DAOException;

    List<T> findAll() throws DAOException;

    void removeById(PK id) throws DAOException;

}

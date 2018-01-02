package com.pavikumbhar.javaheart.common.V2;


import com.pavikumbhar.javaheart.common.V2.GenericDAO;
import com.pavikumbhar.javaheart.common.V2.DAOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavikumbhar
 */
public class GenericDAOJPA<T, PK> implements GenericDAO<T, PK> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> type;

	public GenericDAOJPA(Class<T> type) {
		this.type = type;
	}

	
	@Override
	public T save(T entite) throws DAOException {
		try {
			entityManager.merge(entite);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return entite;
	}

	@Override
	public void remove(T entite) throws DAOException {
		try {
			entityManager.remove(entite);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public T findById(PK id) throws DAOException {
		try {
			return entityManager.find(type, id);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<T> findAll() throws DAOException {
		try {
			return entityManager.createQuery("SELECT o FROM " + type.getSimpleName() + " o", type)
					.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void removeById(PK id) throws DAOException {
		try {
			Query query = entityManager.createQuery("DELETE FROM " + type.getSimpleName()
					+ "  o WHERE o.id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

}

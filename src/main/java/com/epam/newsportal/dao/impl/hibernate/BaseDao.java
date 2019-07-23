package com.epam.newsportal.dao.impl.hibernate;

import com.epam.newsportal.dao.AbstractDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class BaseDao <T extends Serializable> implements AbstractDao<T> {
    private Class<T> entityClass;

    @PersistenceContext(unitName = "newsPU")
    private EntityManager entityManager;

    public BaseDao() {
        entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public T insert(final T entity){
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(final T entity){
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public T delete(final T entity){
        entityManager.remove(entityManager.merge(entity));
        return entity;
    }

    @Override
    public T findOneById(final long id){
        return entityManager.find(entityClass, id);
    }

}
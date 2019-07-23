package com.epam.newsportal.dao;


import java.io.Serializable;

public interface AbstractDao<T extends Serializable> {
    T insert(final T entity);

    T update(final T entity);

    T delete(final T entity);

    T findOneById(final long id);
}

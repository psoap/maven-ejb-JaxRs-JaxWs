package com.epam.newsportal.dao.impl.hibernate;

import com.epam.newsportal.dao.AuthorDao;
import com.epam.newsportal.domain.Author;
import com.epam.newsportal.domain.Author_;

import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Named("authorDao")
public class AuthorDaoImpl extends BaseDao<Author> implements AuthorDao {

    @Override
    public Author findAuthorByUsername(final String username) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Author> criteria = builder.createQuery(Author.class);
        Root<Author> root = criteria.from(Author.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get(Author_.username), username));

        TypedQuery<Author> typed = getEntityManager().createQuery(criteria);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }
}

package com.epam.newsportal.dao.impl.hibernate;

import com.epam.newsportal.dao.NewsDao;
import com.epam.newsportal.domain.News;
import com.epam.newsportal.domain.News_;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Named("newsDao")
public class NewsDaoImpl extends BaseDao<News> implements NewsDao {

    @Override
    public News findNewsByUri(Date date, String uri) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<News> criteriaQuery = builder.createQuery(News.class);
        Root<News> root = criteriaQuery.from(News.class);
        criteriaQuery.select(root).where(
                builder.equal(root.get(News_.uri), uri),
                builder.equal(root.get(News_.changeDate), date)
        );

        return getEntityManager().createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<News> findNewsListByPage(int offset, int limit) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<News> criteriaQuery = builder.createQuery(News.class);
        criteriaQuery.from(News.class);

        TypedQuery query = getEntityManager().createQuery(criteriaQuery);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }
}

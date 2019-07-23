package com.epam.newsportal.dao;

import com.epam.newsportal.domain.News;

import java.util.Date;
import java.util.List;

public interface NewsDao  extends AbstractDao<News> {
    News findNewsByUri(Date date, String uri);
    List<News> findNewsListByPage(final int offset, final int limit);
}

package com.epam.newsportal.ejb;

import com.epam.newsportal.domain.News;

import javax.ejb.Local;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Local
public interface NewsService {
    News getNewsById(final long id);

    News getNewsByUri(final Date date, final String uri);

    List<News> getNewsListByPage(final int pageNumber);
    void addNews(News news);

    void editNews(News news);

    @Transactional
    void removeNews(List<Long> newsId);
}

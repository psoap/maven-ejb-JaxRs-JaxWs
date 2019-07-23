package com.epam.newsportal.ejb;

import com.epam.newsportal.dao.NewsDao;
import com.epam.newsportal.domain.News;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.transaction.Transactional;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Singleton(name = "newsBean")
@WebService(name = "NewsService")
public class NewsBean implements NewsService {
    @Inject
    private NewsDao newsDao;

    private final int NEWS_ON_PAGE_LIMIT = 10;

    public News getNewsById(final long id) {
        return newsDao.findOneById(id);
    }

    public News getNewsByUri(final Date date, final String uri) {
        return newsDao.findNewsByUri(date, uri);
    }

    public List<News> getNewsListByPage(final int pageNumber) {
        return newsDao.findNewsListByPage(pageNumber, NEWS_ON_PAGE_LIMIT);
    }

    public void addNews(News news) {
        if (news.getUri() == null) {
            byte[] rndBytes = new byte[16];
            new Random().nextBytes(rndBytes);
            news.setUri(new String(rndBytes, Charset.forName("utf-8")));
        }
        newsDao.insert(news);
    }

    public void editNews(News news) {
        newsDao.update(news);
    }

    @Transactional
    public void removeNews(List<Long> newsId) {
        newsId.forEach(id -> {
            News n = new News();
            n.setId(id);
            newsDao.delete(n);
        });
    }
}

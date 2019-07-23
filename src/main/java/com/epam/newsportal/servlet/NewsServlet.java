package com.epam.newsportal.servlet;

import com.epam.newsportal.cdi.AuthorSession;
import com.epam.newsportal.ejb.NewsService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;

public class NewsServlet extends HttpServlet{
    @EJB(beanName = "newsBean")
    private NewsService newsService;
    @Inject
    @Named("authorSession")
    private AuthorSession authorSession;

    protected NewsService getNewsService() {
        return newsService;
    }

    protected AuthorSession getAuthorSession() {
        return authorSession;
    }
}

package com.epam.newsportal.servlet;

import com.epam.newsportal.cdi.AuthorSession;
import com.epam.newsportal.ejb.AuthorService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;

public class AuthorServlet extends HttpServlet {
    @EJB(beanName = "authorBean")
    private AuthorService authorService;
    @Inject
    @Named("authorSession")
    private AuthorSession authorSession;

    protected AuthorService getAuthorService() {
        return authorService;
    }

    protected AuthorSession getAuthorSession() {
        return authorSession;
    }
}

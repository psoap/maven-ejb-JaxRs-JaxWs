package com.epam.newsportal.util;

import com.epam.newsportal.domain.Author;
import com.epam.newsportal.domain.News;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class RequestParser {
    public static News parseNews(HttpServletRequest req) {
        News news = new News();
        news.setTitle(req.getParameter("title"));
        news.setBrief(req.getParameter("brief"));
        news.setContent(req.getParameter("content"));
        String uri = req.getParameter("uri");
        news.setUri(uri);
        news.setChangeDate(new Date(req.getParameter("changeDate")));
        String id = req.getParameter("author.id");
        Author author = new Author();
        if (id != null) {
            author.setId(Long.parseLong(id));
        }
        news.setAuthor(author);
        return news;
    }

    public static Author parseAuthor(HttpServletRequest req) {
        Author author = new Author();
        author.setUsername(req.getParameter("username"));
        author.setPassword(req.getParameter("password"));
        return author;
    }
}

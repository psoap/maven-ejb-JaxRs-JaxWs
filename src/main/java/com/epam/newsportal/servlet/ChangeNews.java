package com.epam.newsportal.servlet;

import com.epam.newsportal.util.RequestParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/manage/news/edit", "/manage/news/add"},
        initParams = {
                @WebInitParam(name = "editUri", value = "/news/manage/news/edit")
        })
public class ChangeNews extends NewsServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equals(getInitParameter("editUri"))) {
            req.setAttribute("news", getNewsService().getNewsById(Long.parseLong(req.getParameter("id"))));
        }
        req.getRequestDispatcher("/WEB-INF/jsp/news-change-page.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            getNewsService().addNews(RequestParser.parseNews(req));
        } else {
            getNewsService().editNews(RequestParser.parseNews(req));
        }
        resp.sendRedirect("/news");
    }
}

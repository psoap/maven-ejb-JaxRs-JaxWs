package com.epam.newsportal.servlet;

import com.epam.newsportal.ejb.NewsService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class ShowNewsIndex extends NewsServlet {
    @EJB(beanName = "newsBean")
    private NewsService newsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("news", newsService.getNewsListByPage(0));
        req.getRequestDispatcher("WEB-INF/jsp/news-catalog.jsp").forward(req, resp);
    }
}
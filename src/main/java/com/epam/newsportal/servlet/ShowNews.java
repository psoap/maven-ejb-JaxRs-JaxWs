package com.epam.newsportal.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/news")
public class ShowNews extends NewsServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("news", getNewsService().getNewsById(Long.parseLong(req.getParameter("id"))));
        req.getRequestDispatcher("WEB-INF/jsp/news.jsp").forward(req, resp);
    }
}

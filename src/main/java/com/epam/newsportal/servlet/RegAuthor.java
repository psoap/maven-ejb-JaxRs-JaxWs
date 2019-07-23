package com.epam.newsportal.servlet;

import com.epam.newsportal.util.RequestParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg")
public class RegAuthor extends AuthorServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getAuthorService().registration(RequestParser.parseAuthor(req));
        resp.sendRedirect("/auth");
    }
}
package com.epam.newsportal.servlet;

import com.epam.newsportal.domain.Author;
import com.epam.newsportal.util.RequestParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/auth")
public class AuthAuthor extends AuthorServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AtomicReference<String> redirectUri = new AtomicReference<>("/auth");
        Optional<Author> optionalAuthor = getAuthorService().auth(RequestParser.parseAuthor(req));
        optionalAuthor.ifPresent(author -> {
            getAuthorSession().setCurrentAuthor(optionalAuthor);
            redirectUri.set("/news");
        });
        resp.sendRedirect(redirectUri.get());
    }
}
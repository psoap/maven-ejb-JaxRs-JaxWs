package com.epam.newsportal.dao;

import com.epam.newsportal.domain.Author;

public interface AuthorDao extends AbstractDao<Author>{
    Author findAuthorByUsername(final String username);
}

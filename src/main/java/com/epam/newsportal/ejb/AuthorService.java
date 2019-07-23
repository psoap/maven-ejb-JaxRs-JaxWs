package com.epam.newsportal.ejb;

import com.epam.newsportal.domain.Author;

import javax.ejb.Local;
import java.util.Optional;

@Local
public interface AuthorService {
    Optional<Author> auth(final Author author);
    void registration(final Author author);
}

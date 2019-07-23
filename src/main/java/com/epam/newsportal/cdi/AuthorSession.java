package com.epam.newsportal.cdi;

import com.epam.newsportal.domain.Author;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Optional;

@SessionScoped
@Named("authorSession")
public class AuthorSession implements Serializable {
    private Optional<Author> currentAuthor = Optional.empty();

    public Optional<Author> getCurrentAuthor() {
        return currentAuthor;
    }

    public void setCurrentAuthor(Optional<Author> currentAuthor) {
        this.currentAuthor = currentAuthor;
    }
}
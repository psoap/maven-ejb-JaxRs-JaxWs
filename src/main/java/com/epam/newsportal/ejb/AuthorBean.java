package com.epam.newsportal.ejb;


import com.epam.newsportal.dao.AuthorDao;
import com.epam.newsportal.domain.Author;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.Optional;

@Singleton(name = "authorBean")
public class AuthorBean implements AuthorService{
    @Inject
    private AuthorDao authorDao;

    @Override
    public Optional<Author> auth(Author author) {
        Author dbAuthor = authorDao.findAuthorByUsername(author.getUsername());
        if(dbAuthor != null && dbAuthor.getPassword().equals(author.getPassword())){
            return Optional.of(dbAuthor);
        }
        return Optional.empty();
    }

    public void registration(final Author author){
        final Author databaseAuthor = authorDao.findAuthorByUsername(author.getUsername());
        if(databaseAuthor == null){
            authorDao.insert(author);
        }
    }
}

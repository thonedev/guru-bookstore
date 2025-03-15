package com.th.guru.bookstore.service;

import com.th.guru.bookstore.model.Author;
import com.th.guru.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(long id) {

        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(long id) {
        authorRepository.deleteById(id);
    }
}

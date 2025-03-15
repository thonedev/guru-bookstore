package com.th.guru.bookstore.service;

import com.th.guru.bookstore.model.Author;

public interface AuthorService {
    Author findById(long id);
    Author save(Author author);
    void deleteById(long id);
}

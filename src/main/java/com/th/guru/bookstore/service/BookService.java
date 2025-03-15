package com.th.guru.bookstore.service;

import com.th.guru.bookstore.model.Book;

public interface BookService {
    Book findById(long id);
    Book save(Book book);
    void deleteById(long id);
    Book saveByGoogleApis(String query);
    Iterable<Book> findAll();
}

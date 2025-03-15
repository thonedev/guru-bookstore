package com.th.guru.bookstore.repository;

import com.th.guru.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
}

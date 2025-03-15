package com.th.guru.bookstore.repository;

import com.th.guru.bookstore.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}

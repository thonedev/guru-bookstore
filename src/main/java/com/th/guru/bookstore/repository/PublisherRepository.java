package com.th.guru.bookstore.repository;

import com.th.guru.bookstore.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}

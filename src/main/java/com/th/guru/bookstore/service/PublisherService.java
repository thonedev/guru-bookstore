package com.th.guru.bookstore.service;

import com.th.guru.bookstore.model.Publisher;

public interface PublisherService {
    Publisher findById(long id);
    Publisher save(Publisher publisher);
    void deleteById(long id);
}

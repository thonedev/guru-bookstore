package com.th.guru.bookstore.service;

import com.th.guru.bookstore.model.Publisher;
import com.th.guru.bookstore.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher findById(long id) {
        return publisherRepository.findById(id).orElseThrow();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deleteById(long id) {
        publisherRepository.deleteById(id);
    }
}

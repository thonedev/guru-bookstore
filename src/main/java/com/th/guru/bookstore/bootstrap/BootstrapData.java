package com.th.guru.bookstore.bootstrap;

import com.th.guru.bookstore.repository.BookRepository;
import com.th.guru.bookstore.service.AuthorService;
import com.th.guru.bookstore.service.BookService;
import com.th.guru.bookstore.service.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorService authorService;
    private final BookService bookService;
    private final PublisherService publisherService;
    private final BookRepository bookRepository;

    public BootstrapData(
            AuthorService authorService,
            BookService bookService,
            PublisherService publisherService, BookRepository bookRepository) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        bookService.saveByGoogleApis("q=isbn:9781457501197");
//        bookService.saveByGoogleApis("q=isbn:9780201633610");
//        bookService.saveByGoogleApis("q=isbn:9780132350884");
//        bookService.saveByGoogleApis("q=isbn:9780321834577");

        var books = bookService.findAll();

        for (var book : books){
            System.out.println(book);
        }

    }


}

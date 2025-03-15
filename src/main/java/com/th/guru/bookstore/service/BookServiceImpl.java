package com.th.guru.bookstore.service;

import com.google.gson.Gson;
import com.th.guru.bookstore.dto.BookInfo;
import com.th.guru.bookstore.model.Author;
import com.th.guru.bookstore.model.Book;
import com.th.guru.bookstore.model.Publisher;
import com.th.guru.bookstore.repository.BookRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, PublisherService publisherService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book saveByGoogleApis(String query) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.googleapis.com/books/v1/volumes?" + query)
                .build();

        try (Response response = client.newCall(request).execute()) {
            var res = response.body().string();
            Gson gson = new Gson();
            try {
                var model = gson.fromJson(res, BookInfo.class);


                Set<Author> authors = new HashSet<>();
                for (var author : model.getAuthors()) {
                    var authorModel = new Author();
                    authorModel.setName(author);
                    authorService.save(authorModel);
                    authors.add(authorModel);
                }

                var publisher = new Publisher();
                publisher.setName(model.getPublisher());
                publisherService.save(publisher);

                var book = new Book();

                book.setAuthors(authors);
                book.setPublisher(publisher);
                book.setIsbn(model.getIsbn());
                book.setTitle(model.getTitle());

                return bookRepository.save(book);
            }catch (Exception e){
                return null;
            }
        } catch (IOException e) {
            System.out.println("Book not found");
        }

        return null;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}

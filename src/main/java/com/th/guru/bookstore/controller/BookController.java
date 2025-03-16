package com.th.guru.bookstore.controller;

import com.th.guru.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookService.findAll());

        return "books";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public String create(@RequestParam("isbn") String isbn, Model model) {
        bookService.saveByGoogleApis("q=isbn:" + isbn);

        model.addAttribute("books", bookService.findAll());

        return "books";

    }
}

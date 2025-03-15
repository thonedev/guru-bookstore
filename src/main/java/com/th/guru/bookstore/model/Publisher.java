package com.th.guru.bookstore.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Publisher extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                '}';
    }
}

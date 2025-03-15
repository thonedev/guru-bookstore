package com.th.guru.bookstore.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Author author)) return false;

        return Objects.equals(getId(), author.getId());
    }

    @Override
    public int hashCode() {
        return Long.hashCode(getId());
    }
}

package com.th.guru.bookstore.model;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private String authorsStr;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;

        var sb = new StringBuilder();
        sb.append("Authors{");
        for(var author : authors) {
            sb.append("[");
            sb.append(author.getName());
            sb.append("],");
        }
        if (!authors.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append("}");

        this.authorsStr = sb.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authorsStr +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;

        return getId() == book.getId();
    }

    @Override
    public int hashCode() {
        return Long.hashCode(getId());
    }
}

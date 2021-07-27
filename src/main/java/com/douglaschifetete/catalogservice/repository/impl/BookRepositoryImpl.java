package com.douglaschifetete.catalogservice.repository.impl;

import com.douglaschifetete.catalogservice.domain.Book;
import com.douglaschifetete.catalogservice.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private static final Map<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public Collection<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return existsByIsbn(isbn) ? Optional.of(books.get(isbn)) : Optional.empty();
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

    @Override
    public Book save(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }
}

package com.douglaschifetete.catalogservice.repository;


import com.douglaschifetete.catalogservice.domain.Book;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface BookRepository
        extends CrudRepository<Book,Long> {
    Optional<Book> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    @Transactional
    void deleteByIsbn(String isbn);
}

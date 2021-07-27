package com.douglaschifetete.catalogservice.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String isbn) {
        super("A book with ISBN " + isbn + " not found.");
    }
}

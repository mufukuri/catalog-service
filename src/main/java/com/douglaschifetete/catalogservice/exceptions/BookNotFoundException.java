package com.douglaschifetete.catalogservice.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String isbn) {
        super("The book with ISBN " + isbn + " was not found.");
    }
}

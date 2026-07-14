package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for Spring Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void executeServiceMethod() {
        System.out.println("BookService method executed: Coordinating library operation.");
        if (bookRepository != null) {
            bookRepository.executeRepositoryMethod();
        } else {
            System.out.println("BookRepository is not injected!");
        }
    }
}
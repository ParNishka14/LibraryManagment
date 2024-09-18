package org.example.library;


import org.example.book.Book;
import org.example.book.BookRepository;

import java.util.List;

public class Library {
    private BookRepository repository;

    public Library(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) {
        repository.addBook(book);
    }

    public void removeBook(String isbn) {
        repository.removeBook(isbn);
    }

    public Book findBook(String isbn) {
        return repository.getBook(isbn);
    }

    public List<Book> listAllBooks() {
        return repository.getAllBooks();
    }
}
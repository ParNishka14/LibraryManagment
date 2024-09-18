package org.example.book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    @Override
    public Book getBook(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
package org.example.book;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBookRepository implements BookRepository {
    private static final String FILE_PATH = "books.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Book> books = new ArrayList<>();

    public FileBookRepository() {
        loadBooks();
    }

    private void loadBooks() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                books = objectMapper.readValue(file, new TypeReference<List<Book>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveBooks() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    @Override
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        saveBooks();
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
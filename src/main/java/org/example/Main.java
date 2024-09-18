package org.example;

import org.example.book.*;
import org.example.library.Library;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookRepository inMemoryRepository = new InMemoryBookRepository();
        BookRepository fileRepository = new FileBookRepository();

        Library library = new Library(inMemoryRepository);

        Book book1 = new BookBuilder().setTitle("BratanDripper").setAuthor("Timati").setIsbn("123").setPublicationYear(2013).build();
        Book book2 = new BookBuilder().setTitle("Brushko").setAuthor("Pid").setIsbn("456").setPublicationYear(2024).build();

        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.listAllBooks();
        books.forEach(System.out::println);

        Book foundBook = library.findBook("123");
        System.out.println("Найденная книга: " + foundBook);
        library.removeBook("123");

        books = library.listAllBooks();
        books.forEach(System.out::println);
    }
}
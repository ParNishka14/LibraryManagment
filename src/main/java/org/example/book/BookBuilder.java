package org.example.book;

public class BookBuilder {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    public Book build() {
        return new Book(title, author, isbn, publicationYear);
    }
}
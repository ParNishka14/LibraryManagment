import org.example.book.*;
import org.example.library.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Testi {
    @Test
    void test1(){
        Book book1 = new BookBuilder().setTitle("BratanDripper").setAuthor("Timati").setIsbn("123").setPublicationYear(2013).build();
        assertEquals("Timati", book1.getAuthor());
        assertEquals("BratanDripper", book1.getTitle());
    }

    @Test
    void testAddBook(){
        BookRepository inMemoryRepository = new InMemoryBookRepository();
        Library library = new Library(inMemoryRepository);
        Book book1 = new BookBuilder().setTitle("BratanDripper").setAuthor("Timati").setIsbn("123").setPublicationYear(2013).build();
        library.addBook(book1);
        assertEquals(library.findBook("123").getIsbn(), book1.getIsbn());
    }
    @Test
    void testRemoveBook(){
        BookRepository inMemoryRepository = new InMemoryBookRepository();
        Library library = new Library(inMemoryRepository);
        Book book1 = new BookBuilder().setTitle("BratanDripper").setAuthor("Timati").setIsbn("123").setPublicationYear(2013).build();
        library.addBook(book1);
        library.removeBook("123");
        assertNull(library.findBook("123"));
    }
    @Test
    void testFindBook(){
        BookRepository inMemoryRepository = new InMemoryBookRepository();
        Library library = new Library(inMemoryRepository);
        Book book1 = new BookBuilder().setTitle("BratanDripper").setAuthor("Timati").setIsbn("123").setPublicationYear(2013).build();
        library.addBook(book1);
        assertNotNull(library.findBook("123"));
    }

    @Test
    void testPrintBook(){
        BookRepository inMemoryRepository = new InMemoryBookRepository();
        Library library = new Library(inMemoryRepository);
        Book book1 = new BookBuilder().setTitle("BratanDripper").setAuthor("Timati").setIsbn("123").setPublicationYear(2013).build();
        library.addBook(book1);
        assertNotNull(library.listAllBooks());
    }



}

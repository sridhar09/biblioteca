package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {
    Book book1;
    Book book2;
    Book book3;
    Book book4;

    String detail1;
    String detail2;
    String detail3;
    String detail4;

    @BeforeEach
    void init(){
        book1 = new Book("book1","author1", 2000);
        book2 = new Book("book2","author2", 2000);
        book3 = new Book("book3","author3", 2000);
        book4 = new Book("book4","author4", 2000);

        detail1 = "book1 | author1 | 2000";
        detail2 = "book2 | author2 | 2000";
        detail3 = "book3 | author3 | 2000";
        detail4 = "book4 | author4 | 2000";
    }

    @DisplayName("Should return string of Book Details")
    @Test
    void testForGetBookListBook1AndBook2(){
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        Library library = new Library(books);
        List<String> details = new ArrayList<>();
        details.add(detail1);
        details.add(detail2);
        assertEquals(details,library.getBookList());
    }

    @DisplayName("Should return string of Book Details")
    @Test
    void testForGetBookListBook3AndBook4(){
        List<Book> books = new ArrayList<>();
        books.add(book3);
        books.add(book4);
        Library library = new Library(books);
        List<String> details = new ArrayList<>();
        details.add(detail3);
        details.add(detail4);
        assertEquals(details,library.getBookList());
    }

    @DisplayName("Checked out availableBooks should be in the list of availableBooks")
    @Test
    void testCheckcoutForbook1(){
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Library library = new Library(books);
        List<String> details = new ArrayList<>();
        details.add(detail1);
        details.add(detail2);
        details.add(detail3);
        details.add(detail4);
        assertEquals(details,library.getBookList());

        library.checkout("book1");
        details.remove(detail1);
        assertEquals(details,library.getBookList());
    }

    @DisplayName("Return true for successful checkout of availableBooks")
    @Test
    void testSuccessfulcheckout(){
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Library library = new Library(books);
        assertTrue(library.checkout("book1"));
    }

    @DisplayName("Return false for successful checkout of availableBooks")
    @Test
    void testUnSuccessfulCheckout(){
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Library library = new Library(books);
        assertFalse(library.checkout("book5"));
    }

    @DisplayName("Return true for successful checkout of availableBooks And False for unsuccessful checkout of availableBooks")
    @Test
    void testConsecutiveCheckout(){
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Library library = new Library(books);
        assertTrue(library.checkout("book1"));
        assertFalse(library.checkout("book1"));
    }
    @DisplayName("Checked out availableBooks should be in the list of availableBooks")
    @Test
    void testReturnForBook(){
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Library library = new Library(books);
        List<String> details = new ArrayList<>();
        details.add(detail1);
        details.add(detail2);
        details.add(detail3);
        details.add(detail4);
        assertEquals(details,library.getBookList());

        library.checkout("book1");
        details.remove(detail1);
        assertEquals(details,library.getBookList());

        library.returnItem("book1");
        details.add(detail1);
        assertEquals(details,library.getBookList());
    }

    @DisplayName("Return true for successful checkout of availableBooks")
    @Test
    void testSuccessfulReturn(){
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Library library = new Library(books);
        assertTrue(library.checkout("book1"));
    }

    @DisplayName("Return false for successful checkout of availableBooks")
    @Test
    void testUnSuccessfulReturn(){
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Library library = new Library(books);
        assertFalse(library.checkout("book5"));
    }

}

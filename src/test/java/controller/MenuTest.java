package controller;

import model.Book;
import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MenuTest {

    @Test
    @DisplayName("Should print the list of books")
    void testPrintMenufor2books(){
        Book book1 = new Book("book1", "author1", 2012);
        Book book2 = new Book("book2", "author2", 2013);
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        Library library = new Library(books);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        Menu menu = Menu.LIST_BOOKS;
        menu.action(library,outputDriver,inputDriver);


        verify(outputDriver).println("book1 | author1 | 2012");
        verify(outputDriver).println("book2 | author2 | 2013");
    }

    @Test
    @DisplayName("Should print the list of books")
    void testPrintMenufor3books(){
        Book book1 = new Book("book1", "author1", 2012);
        Book book2 = new Book("book2", "author2", 2013);
        Book book3 = new Book("book3", "author3", 2014);
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        Library library = new Library(books);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        Menu menu = Menu.LIST_BOOKS;
        menu.action(library,outputDriver,inputDriver);


        verify(outputDriver).println("book1 | author1 | 2012");
        verify(outputDriver).println("book2 | author2 | 2013");
        verify(outputDriver).println("book3 | author3 | 2014");
    }

    @Test
    @DisplayName("Should return 'List all the Books.' as display name")
    void testForGetDisplayName(){
        Menu menu = Menu.LIST_BOOKS;
        assertEquals("1. List all the Books.",menu.getDisplayName());
    }

    @Test
    @DisplayName("Should checkout a book form the list of books")
    void testCheckout(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        Menu.CHECKOUT_BOOKS.action(mockLibrary,outputDriver,inputDriver);
        verify(mockLibrary).checkout("Book1");
    }
}

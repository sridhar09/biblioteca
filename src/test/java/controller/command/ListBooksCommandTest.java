package controller.command;

import controller.Menu;
import model.Book;
import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListBooksCommandTest {

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
        new ListBooksCommand().perform(library, inputDriver, outputDriver);


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
        new ListBooksCommand().perform(library, inputDriver, outputDriver);

        verify(outputDriver).println("book1 | author1 | 2012");
        verify(outputDriver).println("book2 | author2 | 2013");
        verify(outputDriver).println("book3 | author3 | 2014");
    }
}
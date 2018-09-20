package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {
    @DisplayName("should print Welcome message on initialization")
    @Test
    void testForWelcomeMessage(){
        OutputDriver mockOutputDriver = mock(OutputDriver.class);
        List<Book> books = new ArrayList<>();
        Library library = new Library(mockOutputDriver, books);
        verify(mockOutputDriver).print("Welcome to Biblioteca");
    }

    @DisplayName("should print list of books")
    @Test
    void testForPrintBookList(){
        OutputDriver mockOutputDriver = mock(OutputDriver.class);
        Book gulliversTravels = new Book("Gulliver's Travels");
        Book ullysses = new Book("Ulysses");
        Book frankenstein= new Book("Frankenstein");
        List<Book> books = new ArrayList<>();
        books.add(gulliversTravels);
        books.add(ullysses);
        books.add(frankenstein);
        Library library = new Library(mockOutputDriver, books);
        library.printBookList();
        verify(mockOutputDriver).print(gulliversTravels);
        verify(mockOutputDriver).print(ullysses);
        verify(mockOutputDriver).print(frankenstein);
    }
}

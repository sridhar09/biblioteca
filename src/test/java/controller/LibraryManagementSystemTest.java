package controller;

import model.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryControllerTest {
    @DisplayName("should print Welcome message on initialization")
    @Test
    void testForWelcomeMessage(){
        OutputDriver mockOutputDriver = mock(OutputDriver.class);
        LibraryController libraryController = new LibraryController(mockOutputDriver);
        verify(mockOutputDriver).print("Welcome to Biblioteca");
    }

    @DisplayName("should print List of the Book")
    @Test
    void testForPrintBookList(){
        OutputDriver mockOutputDriver = mock(OutputDriver.class);
        Book gulliversTravels = new Book("Gulliver's Travels");
        Book ullysses = new Book("Ulysses");
        Book frankenstein= new Book("Frankenstein");
        LibraryController libraryController = new LibraryController(mockOutputDriver);
        List<Book> books = new ArrayList<>();
        books.add(gulliversTravels);
        books.add(ullysses);
        books.add(frankenstein);
        libraryController.printBookList(books);
        verify(mockOutputDriver).print(gulliversTravels);
        verify(mockOutputDriver).print(ullysses);
        verify(mockOutputDriver).print(frankenstein);
    }
}

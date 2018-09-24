package controller.command;

import model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static model.LibraryItemType.BOOK;
import static model.LibraryItemType.MOVIE;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class ListItemsCommandTest {

    @Test
    @DisplayName("Should print the list of books")
    void testPrintMenufor2books(){
        LibraryItem libraryItem1 = new Book("libraryItem1", "author1", 2012);
        LibraryItem libraryItem2 = new Book("libraryItem2", "author2", 2013);
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        Library library = new Library(libraryItems);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        new ListItemsCommand(BOOK).perform(library, inputDriver, outputDriver);


        verify(outputDriver).println("libraryItem1 | author1 | 2012");
        verify(outputDriver).println("libraryItem2 | author2 | 2013");
    }

    @Test
    @DisplayName("Should print the list of books")
    void testPrintMenufor3books(){
        LibraryItem libraryItem1 = new Book("libraryItem1", "author1", 2012);
        LibraryItem libraryItem2 = new Book("libraryItem2", "author2", 2013);
        LibraryItem libraryItem3 = new Book("libraryItem3", "author3", 2014);
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        Library library = new Library(libraryItems);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        new ListItemsCommand(BOOK).perform(library, inputDriver, outputDriver);

        verify(outputDriver).println("libraryItem1 | author1 | 2012");
        verify(outputDriver).println("libraryItem2 | author2 | 2013");
        verify(outputDriver).println("libraryItem3 | author3 | 2014");
    }

    @Test
    @DisplayName("Should print the list of movies")
    void testPrintFor2Movies(){
        LibraryItem libraryItem1 = new Movie("libraryItem1", "director1", 2012, new Rating(10));
        LibraryItem libraryItem2 = new Movie("libraryItem2", "director2", 2013, new Rating(8));
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        Library library = new Library(libraryItems);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        new ListItemsCommand(MOVIE).perform(library, inputDriver, outputDriver);

        verify(outputDriver).println("libraryItem1 | director1 | 2012 | 10");
        verify(outputDriver).println("libraryItem2 | director2 | 2013 | 8");
    }

    @Test
    @DisplayName("Should print the list of movies")
    void testPrintFor3Movies(){
        LibraryItem libraryItem1 = new Movie("libraryItem1", "director1", 2012, new Rating(10));
        LibraryItem libraryItem2 = new Movie("libraryItem2", "director2", 2013, new Rating(8));
        LibraryItem libraryItem3 = new Movie("libraryItem3", "director3", 2014, new Rating(0));
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        Library library = new Library(libraryItems);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        new ListItemsCommand(MOVIE).perform(library, inputDriver, outputDriver);

        verify(outputDriver).println("libraryItem1 | director1 | 2012 | 10");
        verify(outputDriver).println("libraryItem2 | director2 | 2013 | 8");
        verify(outputDriver).println("libraryItem3 | director3 | 2014 | Unrated");
    }

    @Test
    @DisplayName("Should print only Library Item of a particular Library Item Type")
    void testPrintfor3MoviesAnd1Book(){
        LibraryItem libraryItem1 = new Movie("libraryItem1", "director1", 2012, new Rating(10));
        LibraryItem libraryItem2 = new Movie("libraryItem2", "director2", 2013, new Rating(8));
        LibraryItem libraryItem3 = new Movie("libraryItem3", "director3", 2014, new Rating(0));
        LibraryItem libraryItem4 = new Book("libraryItem4", "author1", 2014);
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        libraryItems.add(libraryItem4);
        Library library = new Library(libraryItems);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        new ListItemsCommand(MOVIE).perform(library, inputDriver, outputDriver);

        verify(outputDriver).println("libraryItem1 | director1 | 2012 | 10");
        verify(outputDriver).println("libraryItem2 | director2 | 2013 | 8");
        verify(outputDriver).println("libraryItem3 | director3 | 2014 | Unrated");
        verify(outputDriver,times(0)).println("libraryItem3 | author1 | 2014");
    }
}
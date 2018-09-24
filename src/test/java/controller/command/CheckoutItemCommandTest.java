package controller.command;

import model.Book;
import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static model.LibraryItemType.BOOK;
import static model.LibraryItemType.MOVIE;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutItemCommandTest {
    @Test
    @DisplayName("Should checkout a book form the list of books")
    void testCheckout(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        new CheckoutItemCommand(BOOK).perform(mockLibrary,inputDriver,outputDriver);
        verify(mockLibrary).checkout("Book1",BOOK);
    }

    @Test
    @DisplayName("Should print Success Message when checkout successful")
    void testCheckoutTrue(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        when(mockLibrary.checkout("Book1",BOOK)).thenReturn(true);
        new CheckoutItemCommand(BOOK).perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("Thank you! Enjoy the item");
    }

    @Test
    @DisplayName("Should print Failure Message when checkout unsuccessful")
    void testCheckoutFalse(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        when(mockLibrary.checkout("Book1",BOOK)).thenReturn(false);
        new CheckoutItemCommand(BOOK).perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("That item is not available");
    }

    @Test
    @DisplayName("Should checkout a movie form the list of books")
    void testMovieCheckout(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Movie1");
        new CheckoutItemCommand(MOVIE).perform(mockLibrary,inputDriver,outputDriver);
        verify(mockLibrary).checkout("Movie1",MOVIE);
    }

    @Test
    @DisplayName("Should print Success Message when checkout successful")
    void testMovieCheckoutTrue(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Movie1");
        when(mockLibrary.checkout("Movie1",MOVIE)).thenReturn(true);
        new CheckoutItemCommand(MOVIE).perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("Thank you! Enjoy the item");
    }

    @Test
    @DisplayName("Should print Failure Message when checkout unsuccessful")
    void testCheckoutMovieFalse(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Movie1");
        when(mockLibrary.checkout("Movie1", MOVIE)).thenReturn(false);
        new CheckoutItemCommand(MOVIE).perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("That item is not available");
    }
}
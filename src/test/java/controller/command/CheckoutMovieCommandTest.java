package controller.command;

import controller.Menu;
import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static model.LibraryItemType.BOOK;
import static model.LibraryItemType.MOVIE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutMovieCommandTest {
    @Test
    @DisplayName("Should checkout a movie form the list of books")
    void testCheckout(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Movie1");
        new CheckoutMovieCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(mockLibrary).checkout("Movie1",MOVIE);
    }

    @Test
    @DisplayName("Should print Success Message when checkout successful")
    void testCheckoutTrue(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Movie1");
        when(mockLibrary.checkout("Movie1",MOVIE)).thenReturn(true);
        new CheckoutMovieCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("Thank you! Enjoy the movie");
    }

    @Test
    @DisplayName("Should print Failure Message when checkout unsuccessful")
    void testCheckoutFalse(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Movie1");
        when(mockLibrary.checkout("Movie1", MOVIE)).thenReturn(false);
        new CheckoutMovieCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("That movie is not available");
    }
}
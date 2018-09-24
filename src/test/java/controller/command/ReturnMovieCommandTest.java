package controller.command;

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

class ReturnMovieCommandTest {
    @Test
    @DisplayName("Should checkout a movie form the list of books")
    void testCheckout(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Movie1");
        new ReturnMovieCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(mockLibrary).returnItem("Movie1",MOVIE);
    }

    @Test
    @DisplayName("Should print Success Message when checkout successful")
    void testCheckoutTrue(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Movie1");
        when(mockLibrary.returnItem("Movie1",MOVIE)).thenReturn(true);
        new ReturnMovieCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("Thank you for returning the movie.");
    }

    @Test
    @DisplayName("Should print Failure Message when checkout unsuccessful")
    void testCheckoutFalse(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Movie1");
        when(mockLibrary.returnItem("Movie1", MOVIE)).thenReturn(false);
        new ReturnMovieCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("That is not a valid movie to return.");
    }
}
package controller.command;

import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReturnBookCommandTest {
    @Test
    @DisplayName("Should checkout a book form the list of books")
    void testReturn(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        new ReturnBookCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(mockLibrary).returnItem("Book1");
    }

    @Test
    @DisplayName("Should print Success Message when checkout successful")
    void testReturnTrue(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        when(mockLibrary.returnItem("Book1")).thenReturn(true);
        new ReturnBookCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("Thank you for returning the book.");
    }

    @Test
    @DisplayName("Should print Success Message when checkout successful")
    void testeturnTrue(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        when(mockLibrary.returnItem("Book1")).thenReturn(false);
        new ReturnBookCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("That is not a valid book to return.");
    }

}
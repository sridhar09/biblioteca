package controller.command;

import controller.Menu;
import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutBookCommandTest {
    @Test
    @DisplayName("Should checkout a book form the list of books")
    void testCheckout(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        new CheckoutBookCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(mockLibrary).checkout("Book1");
    }

    @Test
    @DisplayName("Should print Success Message when checkout successful")
    void testCheckoutTrue(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        when(mockLibrary.checkout("Book1")).thenReturn(true);
        new CheckoutBookCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("Thank you! Enjoy the book");
    }

    @Test
    @DisplayName("Should print Failure Message when checkout unsuccessful")
    void testCheckoutFalse(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        when(mockLibrary.checkout("Book1")).thenReturn(false);
        new CheckoutBookCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("That book is not available");
    }

}
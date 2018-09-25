package controller.command;

import model.Library;
import model.LoginCredential;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static model.LibraryItemType.BOOK;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LoginCommandTest {
    @Test
    @DisplayName("Should Call Login Method For Logging In")
    void testForLogin(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("1").thenReturn("1");
        new LoginCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(mockLibrary).login(new LoginCredential("1","1"));
    }

    @Test
    @DisplayName("Should print Succuessful Message for successful login")
    void testForLoginSuccessful(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("1").thenReturn("1");
        when(mockLibrary.login(new LoginCredential("1","1"))).thenReturn(true);
        new LoginCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("You have logged in successfully!");
    }
    @Test
    @DisplayName("Should print Succuessful Message for successful login")
    void testForLoginUnsuccessful(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("1").thenReturn("1");
        when(mockLibrary.login(new LoginCredential("1","1"))).thenReturn(false);
        new LoginCommand().perform(mockLibrary,inputDriver,outputDriver);
        verify(outputDriver).println("Login Failed ");
    }
}
package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.*;

public class LibraryManagementSystemTest {
    @DisplayName("should println Welcome message on initialization")
    @Test
    void testForWelcomeMessage(){
        OutputDriver mockOutputDriver = mock(OutputDriver.class);
        InputDriver mockInputDriver = mock(InputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(mockOutputDriver, mockInputDriver);
        verify(mockOutputDriver).println("Welcome to Biblioteca");
    }

    @DisplayName("should print List of book for List Books Menu")
    @Test
    void testForDisplayMenu(){
        OutputDriver mockOutputDriver = mock(OutputDriver.class);
        InputDriver mockInputDriver = mock(InputDriver.class);
        when(mockInputDriver.readMenuOption()).thenReturn(1).thenReturn(Menu.QUIT.ordinal()+1);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(mockOutputDriver, mockInputDriver);
        libraryManagementSystem.showMenu();
        verify(mockOutputDriver).println("Book1 | Author1 | 1940");
        verify(mockOutputDriver).println("Book2 | Author2 | 1940");
    }

    @DisplayName("Should expect message when invalid input is given")
    @Test
    void testInvalidInput(){
        OutputDriver mockOutputDriver = mock(OutputDriver.class);
        InputDriver mockInputDriver = mock(InputDriver.class);
        when(mockInputDriver.readMenuOption()).thenReturn(Menu.values().length+2).thenReturn(Menu.QUIT.ordinal()+1);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(mockOutputDriver, mockInputDriver);
        libraryManagementSystem.showMenu();
        verify(mockOutputDriver).println("Select a valid option!");
    }
}
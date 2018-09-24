package controller;

import controller.command.ReturnItemCommand;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static model.LibraryItemType.BOOK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MenuTest {

    List<User> users;
    User user1;
    User user2;
    User user3;
    User user4;

    @BeforeEach
    void init(){
        user1 = new User(new LoginCredential("1","1"));
        user2 = new User(new LoginCredential("2","2"));
        user3 = new User(new LoginCredential("3","3"));
        user4 = new User(new LoginCredential("4","4"));
        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    @Test
    @DisplayName("Should print the list of books")
    void testPrintMenufor2books(){
        LibraryItem libraryItem1 = new Book("libraryItem1", "author1", 2012);
        LibraryItem libraryItem2 = new Book("libraryItem2", "author2", 2013);
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        Library library = new Library(libraryItems, users);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        Menu menu = Menu.LIST_BOOKS;
        menu.action(library,outputDriver,inputDriver);


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
        Library library = new Library(libraryItems, users);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        Menu menu = Menu.LIST_BOOKS;
        menu.action(library,outputDriver,inputDriver);


        verify(outputDriver).println("libraryItem1 | author1 | 2012");
        verify(outputDriver).println("libraryItem2 | author2 | 2013");
        verify(outputDriver).println("libraryItem3 | author3 | 2014");
    }

    @Test
    @DisplayName("Should return 'List all the Books.' as display name")
    void testForGetDisplayName(){
        Menu menu = Menu.LIST_BOOKS;
        assertEquals("1. List all the Books.",menu.getDisplayName());
    }

    @Test
    @DisplayName("Should checkout a book form the list of books")
    void testCheckout(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        Menu.CHECKOUT_BOOKS.action(mockLibrary,outputDriver,inputDriver);
        verify(mockLibrary).checkout("Book1", BOOK);
    }

    @Test
    @DisplayName("Should return a book form the list of books")
    void testReturn(){
        Library mockLibrary = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        when(inputDriver.readString()).thenReturn("Book1");
        new ReturnItemCommand(BOOK).perform(mockLibrary,inputDriver,outputDriver);
        verify(mockLibrary).returnItem("Book1",BOOK);
    }
}

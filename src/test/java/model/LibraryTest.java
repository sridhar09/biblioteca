package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static model.LibraryItemType.BOOK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {
    LibraryItem libraryItem1;
    LibraryItem libraryItem2;
    LibraryItem libraryItem3;
    LibraryItem libraryItem4;

    String detail1;
    String detail2;
    String detail3;
    String detail4;

    @BeforeEach
    void init(){
        libraryItem1 = new Book("libraryItem1","author1", 2000);
        libraryItem2 = new Book("libraryItem2","author2", 2000);
        libraryItem3 = new Book("libraryItem3","author3", 2000);
        libraryItem4 = new Book("libraryItem4","author4", 2000);

        detail1 = "libraryItem1 | author1 | 2000";
        detail2 = "libraryItem2 | author2 | 2000";
        detail3 = "libraryItem3 | author3 | 2000";
        detail4 = "libraryItem4 | author4 | 2000";
    }

    @DisplayName("Should return string of LibraryItem Details")
    @Test
    void testForGetBookListBook1AndBook2(){
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        Library library = new Library(libraryItems);
        List<String> details = new ArrayList<>();
        details.add(detail1);
        details.add(detail2);
        assertEquals(details,library.getLibraryItemList(BOOK));
    }

    @DisplayName("Should return string of LibraryItem Details")
    @Test
    void testForGetBookListBook3AndBook4(){
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem3);
        libraryItems.add(libraryItem4);
        Library library = new Library(libraryItems);
        List<String> details = new ArrayList<>();
        details.add(detail3);
        details.add(detail4);
        assertEquals(details,library.getLibraryItemList(BOOK));
    }

    @DisplayName("Checked out availableBooks should be in the list of availableBooks")
    @Test
    void testCheckcoutForbook1(){
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        libraryItems.add(libraryItem4);
        Library library = new Library(libraryItems);
        List<String> details = new ArrayList<>();
        details.add(detail1);
        details.add(detail2);
        details.add(detail3);
        details.add(detail4);
        assertEquals(details,library.getLibraryItemList(BOOK));

        library.checkout("libraryItem1",BOOK);
        details.remove(detail1);
        assertEquals(details,library.getLibraryItemList(BOOK));
    }

    @DisplayName("Return true for successful checkout of availableBooks")
    @Test
    void testSuccessfulcheckout(){
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        libraryItems.add(libraryItem4);
        Library library = new Library(libraryItems);
        assertTrue(library.checkout("libraryItem1",BOOK));
    }

    @DisplayName("Return false for successful checkout of availableBooks")
    @Test
    void testUnSuccessfulCheckout(){
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        libraryItems.add(libraryItem4);
        Library library = new Library(libraryItems);
        assertFalse(library.checkout("book5",BOOK));
    }

    @DisplayName("Return true for successful checkout of availableBooks And False for unsuccessful checkout of availableBooks")
    @Test
    void testConsecutiveCheckout(){
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        libraryItems.add(libraryItem4);
        Library library = new Library(libraryItems);
        assertTrue(library.checkout("libraryItem1",BOOK));
        assertFalse(library.checkout("libraryItem1",BOOK));
    }
    @DisplayName("Checked out availableBooks should be in the list of availableBooks")
    @Test
    void testReturnForBook(){
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        libraryItems.add(libraryItem4);
        Library library = new Library(libraryItems);
        List<String> details = new ArrayList<>();
        details.add(detail1);
        details.add(detail2);
        details.add(detail3);
        details.add(detail4);
        assertEquals(details,library.getLibraryItemList(BOOK));

        library.checkout("libraryItem1",BOOK);
        details.remove(detail1);
        assertEquals(details,library.getLibraryItemList(BOOK));

        library.returnItem("libraryItem1",BOOK);
        details.add(detail1);
        assertEquals(details,library.getLibraryItemList(BOOK));
    }

    @DisplayName("Return true for successful checkout of availableBooks")
    @Test
    void testSuccessfulReturn(){
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        libraryItems.add(libraryItem4);
        Library library = new Library(libraryItems);
        assertTrue(library.checkout("libraryItem1",BOOK));
    }

    @DisplayName("Return false for successful checkout of availableBooks")
    @Test
    void testUnSuccessfulReturn(){
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        libraryItems.add(libraryItem4);
        Library library = new Library(libraryItems);
        assertFalse(library.checkout("book5",BOOK));
    }

}

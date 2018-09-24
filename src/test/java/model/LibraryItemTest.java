package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.LibraryItemType.*;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryItemTest {

    @DisplayName("Should Expect LibraryItem Title as String")
    @Test
    void testForBookTitleTrue1(){
        LibraryItem taleOfTwoCities = new LibraryItem("Tale of two cities", "Charles Dickens", 1940, BOOK);
        assertTrue(taleOfTwoCities.hasTitle("Tale of two cities"));
    }

    @DisplayName("should return true for correct title for Book")
    @Test
    void testForBookTitleTrue2(){
        LibraryItem ulysses = new LibraryItem("Ulysses", "James Joyce", 1940, BOOK);
        assertTrue(ulysses.hasTitle("Ulysses"));
    }

    @DisplayName("Should return false for incorrect title for Book")
    @Test
    void testForBookTitleFalse(){
        LibraryItem taleOfTwoCities = new LibraryItem("Tale of two cities", "Charles Dickens", 1940, BOOK);
        assertFalse(taleOfTwoCities.hasTitle("Ulysses"));
    }

    @DisplayName("should return true for correct item type")
    @Test
    void testForItemTypeTrue1(){
        LibraryItem ulysses = new LibraryItem("Ulysses", "James Joyce", 1940, MOVIE);
        assertTrue(ulysses.hasItemType(MOVIE));
    }

    @DisplayName("Should Expect LibraryItem Title as String")
    @Test
    void testForItemTypeTrue2(){
        LibraryItem taleOfTwoCities = new LibraryItem("Tale of two cities", "Charles Dickens", 1940, BOOK);
        assertTrue(taleOfTwoCities.hasItemType(BOOK));
    }

}

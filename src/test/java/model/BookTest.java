package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @DisplayName("should expect LibraryItem Listing Details as String")
    @Test
    void testForBookNameString1(){
        LibraryItem ulysses = new Book("Ulysses", "James Joyce", 1940);
        assertEquals("Ulysses | James Joyce | 1940", ulysses.toString());
    }

    @DisplayName("should expect LibraryItem Listing Details as String")
    @Test
    void testForBookNameString2(){
        LibraryItem taleOfTwoCities = new Book("Tale of two cities", "Charles Dickens", 1940);
        assertEquals("Tale of two cities | Charles Dickens | 1940", taleOfTwoCities.toString());
    }
}
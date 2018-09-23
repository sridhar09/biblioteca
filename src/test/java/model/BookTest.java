package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @DisplayName("should expect Book Listing Details as String")
    @Test
    void testForBookNameString1(){
        Book ulysses = new Book("Ulysses", "James Joyce", 1940);
        assertEquals("Ulysses", ulysses.toString());
    }

    @DisplayName("should expect Book Listing Details as String")
    @Test
    void testForBookNameString2(){
        Book taleOfTwoCities = new Book("Tale of two cities", "Charles Dickens", 1940);
        assertEquals("Tale of two cities", taleOfTwoCities.toString());
    }

    @DisplayName("Should Expect Book Title as String")
    @Test
    void testForBookTitle1(){
        Book taleOfTwoCities = new Book("Tale of two cities", "Charles Dickens", 1940);
        assertEquals("Tale of two cities", taleOfTwoCities.getTitle());
    }

    @DisplayName("should expect Book Listing Details as String")
    @Test
    void testForBookTitle2(){
        Book ulysses = new Book("Ulysses", "James Joyce", 1940);
        assertEquals("Ulysses", ulysses.getTitle());
    }

}

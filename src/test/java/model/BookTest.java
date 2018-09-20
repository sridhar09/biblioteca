package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @DisplayName("should expect Book Name as String")
    @Test
    void testForBookNameString1(){
        Book ulysses = new Book("Ulysses");
        assertEquals("Ulysses", ulysses.toString());
    }

    @DisplayName("should expect Book Name as String")
    @Test
    void testForBookNameString2(){
        Book taleOfTwoCities = new Book("Tale of two cities");
        assertEquals("Tale of two cities", taleOfTwoCities.toString());
    }
}

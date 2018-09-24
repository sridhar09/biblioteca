package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @DisplayName("should expect LibraryItem Listing Details as String")
    @Test
    void testForBookNameString1(){
        LibraryItem theDarkKnight = new Movie("The Dark Knight", "Christopher Nolan", 2006, new Rating(8));
        assertEquals("The Dark Knight | Christopher Nolan | 2006 | 8", theDarkKnight.toString());
    }

    @DisplayName("should expect LibraryItem Listing Details as String")
    @Test
    void testForBookNameString2(){
        LibraryItem shawshankRedemption = new Movie("Shawshank Redemption", "Frank Darabont", 1994, new Rating (10));
        assertEquals("Shawshank Redemption | Frank Darabont | 1994 | 10", shawshankRedemption.toString());
    }

}
package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {
    @DisplayName("Should return Rating in String")
    @Test
    void testRatingToString5(){
        Rating rating = new Rating(5);
        assertEquals("5",rating.toString());
    }

    @DisplayName("Should return Rating in String")
    @Test
    void testRatingToString10(){
        Rating rating = new Rating(10);
        assertEquals("10",rating.toString());
    }

    @DisplayName("Should Return Unrated for 0")
    @Test
    void testRatingToStringUnrated(){
        Rating rating = new Rating(0);
        assertEquals("Unrated", rating.toString());
    }
}
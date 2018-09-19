package common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryBookTest {
    @DisplayName("should expect Book Name as String")
    @Test
    void testForBookNameString(){
        LibraryBook ulysses = new LibraryBook("Ulysses");
        assertEquals("Ulysses", ulysses.toString());
    }
}

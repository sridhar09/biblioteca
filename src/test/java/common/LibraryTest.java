package common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.OutputDriver;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {
    @DisplayName("should print Welcome message on initialization")
    @Test
    void testForWelcomeMessage(){
        OutputDriver mockOutputDriver = mock(OutputDriver.class);
        Library library = new Library(mockOutputDriver);
        verify(mockOutputDriver).print("Welcome to Biblioteca");
    }

}

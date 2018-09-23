package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ConsoleInputDriverTest {

        @Test
        @DisplayName("Should return 3 for 3 taken from System.in")
        void testMenuInput3() {
            setSystemIn("3\n");

            ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
            assertEquals(3, consoleInputDriver.readMenuOption());
        }

        @Test
        @DisplayName("Should return 2 for 2 taken from System.in")
        void testMenuInput2() {
            setSystemIn("2\n");

            ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
            assertEquals(2, consoleInputDriver.readMenuOption());
        }

        private void setSystemIn(String string) {
            System.setIn(new ByteArrayInputStream(string.getBytes()));
        }

        @AfterEach
        public void resetSystemIn() {
            System.setIn(System.in);
        }
}


import controller.LibraryManagementSystem;
import model.Book;
import view.*;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApplication {
    public static void main(String[] args){
        ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
        ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver,consoleInputDriver);
        libraryManagementSystem.showMenu();
    }
}
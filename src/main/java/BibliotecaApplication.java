
import controller.LibraryManagementSystem;
import view.*;

public class BibliotecaApplication {
    public static void main(String[] args){
        ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
        ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver,consoleInputDriver);
        libraryManagementSystem.showMenu();
    }
}
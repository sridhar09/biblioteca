import controller.LibraryController;
import model.Library;
import model.Book;
import view.*;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApplication {
    public static void main(String[] args){
        ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
        List<Book> books = new ArrayList<>();
        Library library =new Library(consoleOutputDriver, books);
        library.printBookList();
    }
}
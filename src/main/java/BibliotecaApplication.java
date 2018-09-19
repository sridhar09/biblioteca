import common.Library;
import view.*;

public class BibliotecaApplication {
    public static void main(String[] args){
        ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
        Library library =new Library(consoleOutputDriver);
    }
}

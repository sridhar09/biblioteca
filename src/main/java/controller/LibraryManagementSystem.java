package controller;

import model.Book;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.Collection;

public class LibraryManagementSystem {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca";
    private static final String DISPLAY_MENU_MESSAGE = "\nChoose your option from the Menu :";
    private static final String INVALID_MENU_OPTION_MESSAGE = "Select a valid option!\n";
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    public LibraryManagementSystem(OutputDriver outputDriver, InputDriver inputDriver){
        this.outputDriver = outputDriver;
        this.inputDriver = inputDriver;
        library = new Library(returnDummyBooksForLibrary());
        startActivity();
    }

    //Dummy function to add Dummy books
    private Collection<Book> returnDummyBooksForLibrary() {
        Collection<Book> books = new ArrayList<>();
        Book book1 = new Book("Book1", "Author1", 1940);
        Book book2 = new Book("Book2", "Author2", 1940);
        books.add(book1);
        books.add(book2);
        return books;
    }

    private void startActivity(){
        printWelcomeMessage();
    }

    private void printMenu(){
        for (Menu menuItem : Menu.values()){
            outputDriver.println(menuItem.getDisplayName());
        }
        outputDriver.println(DISPLAY_MENU_MESSAGE);
    }

    private boolean isInvalidInput(int choice){
        return choice<0 || choice>=(Menu.values().length);
    }

    public void showMenu(){
        int choice;
        do {
            printMenu();
            choice = inputDriver.readMenuOption() - 1;
            try {
                Menu.values()[choice].action(library, outputDriver, inputDriver);
            }
            catch(ArrayIndexOutOfBoundsException e){
                outputDriver.println(INVALID_MENU_OPTION_MESSAGE);
            }
        } while(choice!=Menu.QUIT.ordinal());
    }

    private void printWelcomeMessage(){
        outputDriver.println(WELCOME_MESSAGE);
    }


}

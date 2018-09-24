package controller;

import model.*;
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
        library = new Library(returnDummyLibraryItemsForLibrary(), returnDummyUserForLibrary());
        startActivity();
    }

    //Dummy function to add Dummy books
    private Collection<LibraryItem> returnDummyLibraryItemsForLibrary() {
        Collection<LibraryItem> libraryItems = new ArrayList<>();
        LibraryItem libraryItem1 = new Book("Book1", "Author1", 1940);
        LibraryItem libraryItem2 = new Book("Book2", "Author2", 1940);
        LibraryItem libraryItem3 = new Book("Book3", "Author3", 1940);
        LibraryItem libraryItem4 = new Movie("Movie1", "Director1", 1940, new Rating(10));
        LibraryItem libraryItem5 = new Movie("Movie2", "Director2", 1940, new Rating(0));
        LibraryItem libraryItem6 = new Movie("Movie3", "Director3", 1940, new Rating(8));
        libraryItems.add(libraryItem1);
        libraryItems.add(libraryItem2);
        libraryItems.add(libraryItem3);
        libraryItems.add(libraryItem4);
        libraryItems.add(libraryItem5);
        libraryItems.add(libraryItem6);
        return libraryItems;
    }

    //Dummy function to add Dummy Users
    private Collection<User> returnDummyUserForLibrary() {
        Collection<User> users = new ArrayList<>();
        User user1 = new User(new LoginCredential("1","1"));
        User user2 = new User(new LoginCredential("2","2"));
        User user3 = new User(new LoginCredential("3","3"));
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
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

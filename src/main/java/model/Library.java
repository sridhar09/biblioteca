package model;

import controller.LibraryController;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.Collection;

public class Library {
    Collection<Book> books;
    private LibraryController libraryController;
    public Library(OutputDriver outputDriver, Collection<Book> books){
        this.books = new ArrayList<>(books);
        libraryController = new LibraryController(outputDriver);
    }

    public void printBookList(){
        libraryController.printBookList(books);
    }

}

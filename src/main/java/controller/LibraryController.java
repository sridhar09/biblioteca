package controller;

import model.Book;
import view.OutputDriver;

import java.util.Collection;

public class LibraryController {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca";
    private OutputDriver outputDriver;
    public LibraryController(OutputDriver outputDriver){
        this.outputDriver = outputDriver;
        this.outputDriver.print(WELCOME_MESSAGE);
    }

    public void printBookList(Collection<Book> books) {
        for(Book book : books){
            outputDriver.print(book);
        }
    }
}

package controller;

import controller.command.*;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public enum Menu {

    LIST_BOOKS("List all the Books.",new ListBooksCommand()),
    CHECKOUT_BOOKS("Checkout a Book.",new CheckoutBookCommand()),
    RETURN_BOOK("Return Book", new ReturnBookCommand()),
    QUIT("Quit",new QuitCommand());

    private final String displayName;
    private final Command action;

    Menu(String displayName, Command action){
        this.displayName = displayName;
        this.action = action;
    }

    public String getDisplayName(){
        return (this.ordinal() + 1) + ". " + displayName;
    }

    public void action(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        action.perform(library, inputDriver, outputDriver);
    }

}

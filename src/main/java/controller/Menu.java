package controller;

import controller.command.*;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

import static model.LibraryItemType.*;

public enum Menu {

    LIST_BOOKS("List all the Books.",new ListItemsCommand(BOOK)),
    CHECKOUT_BOOKS("Checkout a Book.",new CheckoutItemCommand(BOOK)),
    RETURN_BOOK("Return Book", new ReturnItemCommand(BOOK)),
    LIST_MOVIES("List all the Movies.",new ListItemsCommand(MOVIE)),
    CHECKOUT_MOVIES("Checkout a Movie.",new CheckoutItemCommand(MOVIE)),
    RETURN_MOVIES("Return Movie", new ReturnItemCommand(MOVIE)),
    LOGIN("Log in", new LoginCommand()),
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

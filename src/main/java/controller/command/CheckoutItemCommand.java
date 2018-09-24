package controller.command;

import model.Library;
import model.LibraryItemType;
import view.InputDriver;
import view.OutputDriver;

import static model.LibraryItemType.BOOK;

public class CheckoutItemCommand implements Command {
    private static final String INPUT_BOOK_NAME_MESSAGE= "\nEnter Title:";
    private static final String CHECKOUT_SUCCESSFUL_MESSAGE = "Thank you! Enjoy the item";
    private static final String CHECKOUT_UNSUCCESSFUL_MESSAGE = "That item is not available";
    private final LibraryItemType itemType;

    public CheckoutItemCommand(LibraryItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.println(INPUT_BOOK_NAME_MESSAGE);
        String checkoutBook = inputDriver.readString();
        if(library.checkout(checkoutBook, itemType)){
            outputDriver.println(CHECKOUT_SUCCESSFUL_MESSAGE);
        }
        else{
            outputDriver.println(CHECKOUT_UNSUCCESSFUL_MESSAGE);
        }
    }
}

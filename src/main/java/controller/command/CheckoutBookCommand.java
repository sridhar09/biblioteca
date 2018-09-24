package controller.command;

import model.Library;
import model.LibraryItemType;
import view.InputDriver;
import view.OutputDriver;

import static model.LibraryItemType.BOOK;

public class CheckoutBookCommand implements Command {
    private static final String INPUT_BOOK_NAME_MESSAGE= "\nLibrary Item title:";
    private static final String CHECKOUT_SUCCESSFUL_MESSAGE = "Thank you! Enjoy the book";
    private static final String CHECKOUT_UNSUCCESSFUL_MESSAGE = "That book is not available";
    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.println(INPUT_BOOK_NAME_MESSAGE);
        String checkoutBook = inputDriver.readString();
        if(library.checkout(checkoutBook, BOOK)){
            outputDriver.println(CHECKOUT_SUCCESSFUL_MESSAGE);
        }
        else{
            outputDriver.println(CHECKOUT_UNSUCCESSFUL_MESSAGE);
        }
    }
}

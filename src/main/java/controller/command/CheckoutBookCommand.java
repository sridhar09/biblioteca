package controller.command;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class CheckoutBookCommand implements Command {
    private static final String INPUT_BOOK_NAME_MESSAGE= "Book title:\n";
    private static final String CHECKOUT_SUCCESSFUL_MESSAGE = "Thank you! Enjoy the book";
    private static final String CHECKOUT_UNSUCCESSFUL_MESSAGE = "That book is not available";
    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.println(INPUT_BOOK_NAME_MESSAGE);
        String checkoutBook = inputDriver.readString();
        if(library.checkout(checkoutBook)){
            outputDriver.println(CHECKOUT_SUCCESSFUL_MESSAGE);
        }
        else{
            outputDriver.println(CHECKOUT_UNSUCCESSFUL_MESSAGE);
        }
    }
}

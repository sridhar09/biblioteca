package controller.command;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

import static model.LibraryItemType.BOOK;
import static model.LibraryItemType.MOVIE;

public class CheckoutMovieCommand implements Command{
    private static final String INPUT_BOOK_NAME_MESSAGE= "\nMovie title:";
    private static final String CHECKOUT_SUCCESSFUL_MESSAGE = "Thank you! Enjoy the movie";
    private static final String CHECKOUT_UNSUCCESSFUL_MESSAGE = "That movie is not available";
    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.println(INPUT_BOOK_NAME_MESSAGE);
        String checkoutMovie = inputDriver.readString();
        if(library.checkout(checkoutMovie, MOVIE)){
            outputDriver.println(CHECKOUT_SUCCESSFUL_MESSAGE);
        }
        else{
            outputDriver.println(CHECKOUT_UNSUCCESSFUL_MESSAGE);
        }
    }
}

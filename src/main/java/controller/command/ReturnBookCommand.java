package controller.command;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class ReturnBookCommand implements Command {
    private static final String INPUT_BOOK_NAME_MESSAGE= "Book title:\n";
    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.println(INPUT_BOOK_NAME_MESSAGE);
        String returnBook = inputDriver.readString();
        library.returnItem(returnBook);
    }
}

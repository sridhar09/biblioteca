package controller.command;

import model.Library;
import model.LibraryItemType;
import view.InputDriver;
import view.OutputDriver;

public class ReturnItemCommand implements Command {
    private static final String INPUT_ITEM_NAME_MESSAGE = "Title:\n";
    private static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the item.";
    private static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid item to return.";
    private final LibraryItemType itemType;

    public ReturnItemCommand(LibraryItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.println(INPUT_ITEM_NAME_MESSAGE);
        String returnBook = inputDriver.readString();
        if(library.returnItem(returnBook,itemType)){
            outputDriver.println(SUCCESSFUL_RETURN_MESSAGE);
        }
        else{
            outputDriver.println(UNSUCCESSFUL_RETURN_MESSAGE);
        }
    }
}

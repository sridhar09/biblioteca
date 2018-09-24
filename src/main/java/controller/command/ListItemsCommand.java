package controller.command;

import model.Library;
import model.LibraryItemType;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

public class ListItemsCommand implements Command {
    private final LibraryItemType itemType;

    public ListItemsCommand(LibraryItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        Collection<String> bookDetails = library.getLibraryItemList(itemType);
        for(String bookDetail : bookDetails){
            outputDriver.println(bookDetail);
        }
    }
}

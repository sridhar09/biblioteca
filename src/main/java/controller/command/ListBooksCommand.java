package controller.command;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

public class ListBooksCommand implements Command {
    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        Collection<String> bookDetails = library.getBookList();
        for(String bookDetail : bookDetails){
            outputDriver.println(bookDetail);
        }
    }
}

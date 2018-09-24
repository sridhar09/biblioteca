package controller.command;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

import static model.LibraryItemType.MOVIE;

public class ReturnMovieCommand implements Command{
    private static final String INPUT_BOOK_NAME_MESSAGE= "Movie title:\n";
    private static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the movie.";
    private static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid movie to return.";
    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.println(INPUT_BOOK_NAME_MESSAGE);
        String returnBook = inputDriver.readString();
        if(library.returnItem(returnBook,MOVIE)){
            outputDriver.println(SUCCESSFUL_RETURN_MESSAGE);
        }
        else{
            outputDriver.println(UNSUCCESSFUL_RETURN_MESSAGE);
        }
    }
}

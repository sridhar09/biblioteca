package controller.command;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class QuitCommand implements Command{

    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        System.exit(0);
    }
}

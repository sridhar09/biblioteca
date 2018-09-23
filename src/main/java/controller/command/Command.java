package controller.command;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

public interface Command {
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver);
}

package controller.command;

import model.Library;
import model.LoginCredential;
import view.InputDriver;
import view.OutputDriver;

public class LoginCommand implements Command {
    private static final String ENTER_USERNAME_NUMBER= "\nUsername: ";
    private static final String ENTER_PASSWORD_NUMBER= "\nPassword: ";

    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.println(ENTER_USERNAME_NUMBER);
        String userName = inputDriver.readString();
        outputDriver.println(ENTER_PASSWORD_NUMBER);
        String password = inputDriver.readString();
        LoginCredential loginCredential = new LoginCredential(userName,password);
        library.login(loginCredential);
    }
}

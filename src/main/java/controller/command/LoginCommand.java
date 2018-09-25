package controller.command;

import model.Library;
import model.LoginCredential;
import view.InputDriver;
import view.OutputDriver;

public class LoginCommand implements Command {
    private static final String ENTER_USERNAME_NUMBER= "\nUsername: ";
    private static final String ENTER_PASSWORD_NUMBER= "\nPassword: ";
    private static final String LOGIN_SUCCESSFUL_MESSAGE= "You have logged in successfully!";
    private static final String LOGIN_UNSUCCESSFUL_MEASSAGE= "Login Failed ";

    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.println(ENTER_USERNAME_NUMBER);
        String userName = inputDriver.readString();
        outputDriver.println(ENTER_PASSWORD_NUMBER);
        String password = inputDriver.readString();
        LoginCredential loginCredential = new LoginCredential(userName,password);
        if(library.login(loginCredential)){
            outputDriver.println(LOGIN_SUCCESSFUL_MESSAGE);
        }
        else{
            outputDriver.println(LOGIN_UNSUCCESSFUL_MEASSAGE);
        }
    }
}

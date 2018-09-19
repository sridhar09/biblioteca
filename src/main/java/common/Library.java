package common;

import view.OutputDriver;

import static view.OutputDriver.*;

public class Library {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca";
    public Library(OutputDriver outputDriver){
        outputDriver.print(WELCOME_MESSAGE);
    }
}

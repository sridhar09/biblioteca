package view;

import java.util.Scanner;

public class ConsoleInputDriver implements InputDriver{
    Scanner scanner;
    public ConsoleInputDriver(){
        scanner = new Scanner(System.in);
    }

    @Override
    public int readMenuOption()
    {
        return scanner.nextInt();
    }

    @Override
    public String readString()
    {
        return scanner.next();
    }
}

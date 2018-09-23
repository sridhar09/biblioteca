package view;

import java.util.List;

public class ConsoleOutputDriver implements OutputDriver{
    @Override
    public void println(Object object) {
        System.out.println(object);
    }
}

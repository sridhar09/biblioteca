package view;

public class ConsoleOutputDriver implements OutputDriver{
    @Override
    public void print(Object object) {
        System.out.println(object);
    }
}

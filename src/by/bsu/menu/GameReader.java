package by.bsu.menu;

import java.util.Scanner;

public class GameReader implements AutoCloseable {

    private Scanner sc;

    public GameReader() {
        sc = new Scanner(System.in);
    }

    public String readPlayerValue() {
        return sc.next().toLowerCase();
    }

    @Override
    public void close() throws Exception {
        sc.close();
    }
}

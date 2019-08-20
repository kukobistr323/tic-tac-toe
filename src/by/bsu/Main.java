package by.bsu;

import by.bsu.logic.Game;
import by.bsu.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(new Game());
        menu.start();
    }
}

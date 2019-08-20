package by.bsu.menu;

import by.bsu.exceptions.WrongInputException;
import by.bsu.logic.*;
import by.bsu.logic.observer.Observers;

import java.util.Scanner;

public class Menu {
    private Observers observers;
    private Player player;
    private Bot bot;
    private Checker checker;
    private Printer printer;

    public Menu() {
        player = new Player();
        bot = new Bot();
        checker = new Checker();
        printer = new Printer();
        observers = new Observers();
        observers.addObserver(bot);
        observers.addObserver(player);
        observers.addObserver(checker);
        observers.addObserver(printer);
    }

    public void start() {
        String type;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s to play vs computer\n\tm to play vs opponent\n\tq to quit");
        do {
            type = sc.next().toLowerCase();
            if (type.equals("s"))
                singleplay();
            if (type.equals("m"))
                multiplay();
            observers.setNewGame();
        } while (!type.equals("q"));
    }

    private void singleplay() {
        int order = ((int) Math.random()) * 2 + 1;
        Indexes ind;
        String input;
        Scanner sc = new Scanner(System.in);
        if (order == 2) {
            ind = bot.step();
            observers.notifyObservers(ind);
        }
        while (!checker.isWin() && !checker.isDraw()) {
            System.out.println(printer.stringField());
            System.out.println("Enter position of your step: ");
            try {
                input = sc.next();
                ind = player.step(input);
                observers.notifyObservers(ind);
                ind = bot.step();
                observers.notifyObservers(ind);
            } catch (WrongInputException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (checker.isWin())
            System.out.println("Congratulations! Player " + checker.getPlayerNumber() + " won!");
        else
            System.out.println("Draw");
    }

    private void multiplay() {
        String input;
        Indexes ind;
        Scanner sc = new Scanner(System.in);
        while (!checker.isWin() && !checker.isDraw()) {
            System.out.println(printer.stringField());
            System.out.println("Enter position of your step: ");
            try {
                input = sc.next();
                ind = player.step(input);
                observers.notifyObservers(ind);
            } catch (WrongInputException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (checker.isWin())
            System.out.println("Congratulations! Player " + checker.getPlayerNumber() + " won!");
        else
            System.out.println("Draw");
    }
}

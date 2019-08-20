package by.bsu.menu;

import by.bsu.exceptions.WrongInputException;
import by.bsu.logic.*;

import java.util.Scanner;

public class Menu {
    private Game game;
    private Player player;
    private Bot bot;
    private Checker checker;

    public Menu(Game game) {
        this.game = game;
        player = new Player(game);
        bot = new Bot(game);
        checker = new Checker(game);
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
            game.newGame();
        } while (!type.equals("q"));
    }

    private void singleplay() {
        int order = ((int) Math.random()) * 2 + 1;
        String input;
        Scanner sc = new Scanner(System.in);
        if (order == 2) {
            bot.step();
        }
        while (!checker.isWin() && !checker.isDraw()) {
            System.out.println(Printer.stringField(game.getField()));
            System.out.println("Enter position of your step: ");
            try {
                input = sc.next();
                player.step(input);
                bot.step();
            } catch (WrongInputException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(Printer.stringWin(checker));
    }

    private void multiplay() {
        String input;
        Scanner sc = new Scanner(System.in);
        while (!checker.isWin() && !checker.isDraw()) {
            System.out.println(Printer.stringField(game.getField()));
            System.out.println("Enter position of your step: ");
            try {
                input = sc.next();
                player.step(input);
            } catch (WrongInputException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(Printer.stringWin(checker));
    }
}

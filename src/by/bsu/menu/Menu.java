package by.bsu.menu;

import by.bsu.exceptions.WrongInputException;
import by.bsu.logic.Game;

import java.util.Scanner;

public class Menu {
    private Game game;

    public Menu(Game game) {
        this.game = game;
    }

    public void play() {
        String type;
        System.out.println("Enter s to play vs computer\n\tm to play vs opponent\n\tq to quit");
        do {
            Scanner sc = new Scanner(System.in);
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
        if (order == 2)
            game.botStep(order);
        while (!game.isWin() && !game.isDraw()) {
            System.out.println(game);
            System.out.println("Enter position of your step: ");
            try {
                input = sc.next();
                game.step(input);
                game.botStep(order);
            } catch (WrongInputException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (game.isWin())
            System.out.println("Congratulations! Player " + game.getPlayerNumber() + " won!");
        else
            System.out.println("Draw");
    }

    private void multiplay() {
        String input;
        Scanner sc = new Scanner(System.in);
        while (!game.isWin() && !game.isDraw()) {
            System.out.println(game);
            System.out.println("Enter position of your step: ");
            try {
                input = sc.next();
                game.step(input);
            } catch (WrongInputException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (game.isWin())
            System.out.println("Congratulations! Player " + game.getPlayerNumber() + " won!");
        else
            System.out.println("Draw");
    }
}

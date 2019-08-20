package by.bsu.menu;

import by.bsu.exceptions.BusyCellException;
import by.bsu.exceptions.WrongInputException;
import by.bsu.logic.*;

public class Menu {
    private Game game;
    private Player player;
    private Bot bot;
    private Checker checker;
    private GameReader reader;
    private GameType type;

    public Menu(Game game) {
        this.game = game;
        player = new Player(game);
        bot = new Bot(game);
        checker = new Checker(game);
        reader = new GameReader();
    }

    public void start() {
        String command;
        do {
            System.out.println("Enter s to play vs computer\n\tm to play vs opponent\n\tq to quit");
            command = reader.readPlayerValue();
            if ("s".equals(command)) {
                final int order = ((int) Math.random()) * 2 + 1;
                type = () -> {
                    if (game.getPlayerNumber() == order) {
                        playerStep();
                    } else {
                        bot.step();
                    }
                };
                play();
            }
            if ("m".equals(command)) {
                type = () -> playerStep();
                play();
            }
            game.newGame();
        } while (!"q".equals(command));
    }


    private void play() {
        while (!checker.isWin() && !checker.isDraw()) {
            System.out.println(Printer.stringField(game.getField()));
            type.putSymbol();
        }
        System.out.println(Printer.stringWin(checker));
    }

    private void playerStep() {
        try {
            String input;
            System.out.println("Enter position of your step: ");
            input = reader.readPlayerValue();
            player.step(input);
        } catch (WrongInputException ex) {
            System.out.println(ex.getMessage());
        } catch (BusyCellException ex){
            System.out.println(ex.getMessage());
        }
    }
}

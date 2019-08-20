package by.bsu.logic;

import by.bsu.exceptions.WrongInputException;

import static by.bsu.logic.Game.FIELD_SIZE;

public class Player {

    private Game game;

    public Player() {
    }

    public Player(Game game) {
        this.game = game;
    }

    public void step(String input) throws WrongInputException {
        game.incrementSteps();
        if (!input.matches("^[1-9]$")) {
            throw new WrongInputException("Wrong position");
        }
        int position = Integer.parseInt(input);
        position--;
        int row = position / FIELD_SIZE;
        int col = position % FIELD_SIZE;
        game.getField()[row][col] = State.getValue(game.getSteps() % 2);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

package by.bsu.logic;

import static by.bsu.logic.Game.FIELD_SIZE;

public class Bot {

    private Game game;

    public Bot() {
    }

    public Bot(Game game) {
        this.game = game;
    }

    public void step() {
        int row;
        int col;
        do {
            row = (int) (Math.random() * FIELD_SIZE);
            col = (int) (Math.random() * FIELD_SIZE);
        } while (State.EMPTY!=game.getField()[row][col]);
        game.getField()[row][col] = State.getValue(game.getSteps() % 2);
        game.incrementSteps();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

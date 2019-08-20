package by.bsu.logic;

import static by.bsu.logic.Game.FIELD_SIZE;

public class Checker {

    private Game game;

    public Checker() {
    }

    public Checker(Game game) {
        this.game = game;
    }

    public boolean isDraw() {
        return game.getSteps() == FIELD_SIZE * FIELD_SIZE;
    }

    public boolean isWin() {
        return isWinDiagonals() || isWinHorizontal() || isWinVertical();
    }

    private boolean isWinHorizontal() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            boolean result = State.EMPTY != game.getField()[i][0];
            for (int j = 1; j < FIELD_SIZE && result; j++)
                result = game.getField()[i][j] == game.getField()[i][0];
            if (result)
                return true;
        }
        return false;
    }

    private boolean isWinVertical() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            boolean result = State.EMPTY != game.getField()[0][i];
            for (int j = 1; j < FIELD_SIZE && result; j++)
                result = game.getField()[j][i] == game.getField()[0][i];
            if (result)
                return true;
        }
        return false;
    }

    private boolean isWinDiagonals() {
        boolean result = State.EMPTY != game.getField()[0][0];
        for (int i = 1; i < FIELD_SIZE && result; i++)
            result = game.getField()[i][i] == game.getField()[0][0];
        if (result)
            return true;
        result = State.EMPTY != game.getField()[FIELD_SIZE - 1][0];
        for (int i = 1; i < FIELD_SIZE && result; i++)
            result = game.getField()[FIELD_SIZE - i - 1][i] == game.getField()[FIELD_SIZE - 1][0];
        return result;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

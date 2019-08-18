package by.bsu.logic;

import by.bsu.exceptions.WrongInputException;

import java.util.Arrays;

public class Game {
    public static final int FIELD_SIZE = 3;

    private enum State {
        O, X, EMPTY;

        public static State getValue(int index) {
            return State.values()[index];
        }
    }

    ;
    private Enum<State> field[][];
    private int steps;


    public Game() {
        field = new Enum[FIELD_SIZE][FIELD_SIZE];
        newGame();
    }

    public void newGame() {
        steps = 0;
        for (Enum<State>[] row : field)
            Arrays.fill(row, State.EMPTY);
    }

    public int getPlayerNumber() {
        if (steps % 2 == 1)
            return 1;
        else
            return 2;
    }

    public void step(String input) throws WrongInputException {

        if (!input.matches("^[1-9]$"))
            throw new WrongInputException("Wrong position");
        int position = Integer.parseInt(input);
        position--;
        steps++;
        int col = position / FIELD_SIZE;
        int row = position % FIELD_SIZE;
        field[col][row] = State.getValue(steps % 2);
    }

    public void botStep(int order) {
        steps++;
        int row = 0;
        int col = 0;
        do {
            row = (int) (Math.random() * FIELD_SIZE);
            col = (int) (Math.random() * FIELD_SIZE);
        } while (field[col][row].equals(State.O) || field[col][row].equals(State.X));
        field[col][row] = State.getValue(steps % 2);
    }

    public boolean isDraw() {
        return steps == FIELD_SIZE * FIELD_SIZE;
    }

    public boolean isWin() {
        return isWinDiagonals() || isWinHorizontal() || isWinVertical();
    }

    private boolean isWinHorizontal() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            boolean result = !field[i][0].equals(State.EMPTY);
            for (int j = 1; j < FIELD_SIZE && result; j++)
                result = field[i][j].equals(field[i][0]);
            if (result)
                return true;
        }
        return false;
    }

    private boolean isWinVertical() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            boolean result = !field[0][i].equals(State.EMPTY);
            for (int j = 1; j < FIELD_SIZE && result; j++)
                result = field[j][i].equals(field[0][i]);
            if (result)
                return true;
        }
        return false;
    }

    private boolean isWinDiagonals() {
        boolean result = !field[0][0].equals(State.EMPTY);
        for (int i = 1; i < FIELD_SIZE && result; i++)
            result = field[i][i].equals(field[0][0]);
        if (result)
            return true;
        result = !field[FIELD_SIZE - 1][0].equals(State.EMPTY);
        for (int i = 1; i < FIELD_SIZE && result; i++)
            result = field[FIELD_SIZE - i - 1][i].equals(field[FIELD_SIZE - 1][0]);
        return result;
    }

    @Override
    public String toString() {
        int position = 1;
        String underscore = getStringUnderscore();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < FIELD_SIZE; i++) {

            for (int j = 0; j < FIELD_SIZE; j++) {
                if (!field[i][j].equals(State.EMPTY))
                    sb.append(field[i][j]);
                else
                    sb.append(position);
                if (j != FIELD_SIZE - 1)
                    sb.append("|");
                position++;
            }
            sb.append("\n").append(underscore).append("\n");
        }
        return sb.toString();
    }

    private String getStringUnderscore() {
        StringBuilder underscore = new StringBuilder();
        int length = FIELD_SIZE * 2;
        for (int i = 0; i < length; i++)
            underscore.append('-');
        return underscore.toString();
    }

}

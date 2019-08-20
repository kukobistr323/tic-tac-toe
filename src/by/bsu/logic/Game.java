package by.bsu.logic;


import java.util.Arrays;
import java.util.Objects;

public class Game {
    public static final int FIELD_SIZE = 3;

    protected Enum<State> field[][];
    protected int steps;


    public Game() {
        field = new Enum[FIELD_SIZE][FIELD_SIZE];
        newGame();
    }

    public int getPlayerNumber() {
        if (steps % 2 == 0)
            return 1;
        else
            return 2;

    }

    public void incrementSteps() {
        steps++;
    }

    public void newGame() {
        steps = 1;
        for (Enum<State>[] row : field)
            Arrays.fill(row, State.EMPTY);
    }

    public Enum<State>[][] getField() {
        return field;
    }

    public void setField(Enum<State>[][] field) {
        this.field = field;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public State getSymbol() {
        return State.getValue(steps % 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return steps == game.steps &&
                Arrays.equals(field, game.field);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(steps);
        result = 31 * result + Arrays.hashCode(field);
        return result;
    }
}

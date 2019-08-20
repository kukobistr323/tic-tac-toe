package by.bsu.logic;

import by.bsu.logic.observer.Observer;

public class Bot extends Game {

    public Indexes step() {
        int row = 0;
        int col = 0;
        do {
            row = (int) (Math.random() * FIELD_SIZE);
            col = (int) (Math.random() * FIELD_SIZE);
        } while (!State.EMPTY.equals(field[row][col]));
        field[row][col] = State.getValue(steps % 2);
        return new Indexes(row, col);
    }
}

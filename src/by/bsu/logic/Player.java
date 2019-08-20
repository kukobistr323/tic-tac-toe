package by.bsu.logic;

import by.bsu.exceptions.WrongInputException;

public class Player extends Game {

    public Indexes step(String input) throws WrongInputException {

        if (!input.matches("^[1-9]$")) {
            throw new WrongInputException("Wrong position");
        }
        int position = Integer.parseInt(input);
        position--;
        int row = position / FIELD_SIZE;
        int col = position % FIELD_SIZE;
        field[row][col] = State.getValue(steps % 2);
        return new Indexes(row,col);
    }
}

package by.bsu.logic;

public class Checker extends Game {

    public boolean isDraw() {
        return steps == FIELD_SIZE * FIELD_SIZE;
    }

    public boolean isWin() {
        return isWinDiagonals() || isWinHorizontal() || isWinVertical();
    }

    private boolean isWinHorizontal() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            boolean result = !State.EMPTY.equals(field[i][0]);
            for (int j = 1; j < FIELD_SIZE && result; j++)
                result = field[i][j].equals(field[i][0]);
            if (result)
                return true;
        }
        return false;
    }

    private boolean isWinVertical() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            boolean result = !State.EMPTY.equals(field[0][i]);
            for (int j = 1; j < FIELD_SIZE && result; j++)
                result = field[j][i].equals(field[0][i]);
            if (result)
                return true;
        }
        return false;
    }

    private boolean isWinDiagonals() {
        boolean result = !State.EMPTY.equals(field[0][0]);
        for (int i = 1; i < FIELD_SIZE && result; i++)
            result = field[i][i].equals(field[0][0]);
        if (result)
            return true;
        result = !State.EMPTY.equals(field[FIELD_SIZE - 1][0]);
        for (int i = 1; i < FIELD_SIZE && result; i++)
            result = field[FIELD_SIZE - i - 1][i].equals(field[FIELD_SIZE - 1][0]);
        return result;
    }
}

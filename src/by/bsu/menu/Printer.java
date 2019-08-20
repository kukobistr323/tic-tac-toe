package by.bsu.menu;

import by.bsu.logic.Checker;
import by.bsu.logic.State;

import static by.bsu.logic.Game.FIELD_SIZE;

public class Printer {

    public static String stringField(Enum<State> field[][]) {

        int position = 1;
        String underscore = getStringUnderscore();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {

                if (State.EMPTY != field[i][j]) {
                    sb.append(field[i][j]);
                } else {
                    sb.append(position);
                }

                if (j != FIELD_SIZE - 1) {
                    sb.append("|");
                }

                position++;
            }
            sb.append("\n").append(underscore).append("\n");
        }

        return sb.toString();
    }

    private static String getStringUnderscore() {
        StringBuilder underscore = new StringBuilder();
        int length = FIELD_SIZE * 2;

        for (int i = 0; i < length; i++) {
            underscore.append('-');
        }

        return underscore.toString();
    }

    public static String stringWin(Checker checker) {
        if (checker.isWin())
            return "Congratulations! Player " + checker.getGame().getPlayerNumber() + " won!";
        else
            return "Draw";
    }

}

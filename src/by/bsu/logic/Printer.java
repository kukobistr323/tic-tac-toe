package by.bsu.logic;

public class Printer extends Game{

    public String stringField() {

        int position = 1;
        String underscore = getStringUnderscore();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {

                if (!State.EMPTY.equals(field[i][j])) {
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

    private String getStringUnderscore() {
        StringBuilder underscore = new StringBuilder();
        int length = FIELD_SIZE * 2;

        for (int i = 0; i < length; i++) {
            underscore.append('-');
        }

        return underscore.toString();
    }
}

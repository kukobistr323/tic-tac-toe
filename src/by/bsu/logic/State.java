package by.bsu.logic;

public enum State {
    O, X, EMPTY;

    public static State getValue(int index) {
        return State.values()[index];
    }
}

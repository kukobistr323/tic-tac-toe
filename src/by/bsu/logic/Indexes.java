package by.bsu.logic;

import java.util.Objects;

public class Indexes {
    private int row;
    private int col;

    public Indexes() {
    }

    public Indexes(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indexes indexes = (Indexes) o;
        return row == indexes.row &&
                col == indexes.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

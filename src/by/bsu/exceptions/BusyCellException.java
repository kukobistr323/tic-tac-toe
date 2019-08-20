package by.bsu.exceptions;

public class BusyCellException extends Exception {

    public BusyCellException() {
        super();
    }

    public BusyCellException(String message) {
        super(message);
    }

    public BusyCellException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusyCellException(Throwable cause) {
        super(cause);
    }
}
package chess;

public class AlreadyOccupiedException extends RuntimeException {

    public AlreadyOccupiedException(String message) {
        super(message);
    }

    public AlreadyOccupiedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

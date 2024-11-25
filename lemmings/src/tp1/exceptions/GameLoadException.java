package tp1.exceptions;

public class GameLoadException extends Exception {
    public GameLoadException(String message) {
        super(message);
    }

    public GameLoadException(String message, Throwable e) {
        super(message, e);
    }
}

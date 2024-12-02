package tp1.exceptions;


public class GameModelException extends Exception {
    public GameModelException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameModelException(String message) {
        super(message);
    }
}

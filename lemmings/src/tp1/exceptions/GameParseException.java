package tp1.exceptions;

public class GameParseException extends GameModelException {
    public GameParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameParseException(String message) {
        super(message);
    }
}

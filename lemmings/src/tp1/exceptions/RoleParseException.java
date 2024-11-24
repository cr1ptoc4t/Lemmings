package tp1.exceptions;

public class RoleParseException extends GameParseException {
    public RoleParseException(String message, Throwable cause) {
        super(message, cause);
    }
    public RoleParseException(String message) {
        super(message);
    }
}

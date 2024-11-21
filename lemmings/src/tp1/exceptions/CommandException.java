package tp1.exceptions;

public class CommandException extends Exception{
    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable e) {
        super(message, e);
    }
}

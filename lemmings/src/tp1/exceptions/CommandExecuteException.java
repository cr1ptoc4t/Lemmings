package tp1.exceptions;

public class CommandExecuteException extends CommandException {
    public CommandExecuteException(String message, Throwable e) {
        super(message, e);
    }
    public CommandExecuteException(String message){
        super(message);
    }
}

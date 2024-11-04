package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command{

    private static final String NAME = Messages.COMMAND_ROLE_NAME;
    private static final String SHORTCUT = Messages.COMMAND_ROLE_SHORTCUT;
    private static final String DETAILS = Messages.COMMAND_ROLE_DETAILS;
    private static final String HELP = Messages.COMMAND_ROLE_HELP;
    public SetRoleCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public void execute(Game game, GameView view) {
        game.setRole();
        view.showGame();
    }

    @Override
    public Command parse(String[] commandWords) {
        if(commandWords.length==4 && this.matchCommandName(commandWords[0])){
            return this;
        }
        else return null;
    }
}

package tp1.control;

import tp1.logic.Game;
import tp1.logic.gameobjects.Lemming;
import tp1.view.GameView;
import tp1.view.Messages;

import javax.swing.text.View;
import java.util.Arrays;

/**
 * Accepts user input and coordinates the game execution logic
 */
public class Controller {

    private Game game;
    private GameView view;
    private boolean _advance = true;

    public Controller(Game game, GameView view) {
        this.game = game;
        this.view = view;
    }


    /**
     * Runs the game logic, coordinate Model(game) and View(view)
     */
    public void run() {
        view.showWelcome();
        //view.showGame();
        String cd;
        do {
            view.showGame();
            do {
                _advance=true;
                cd = view.getPrompt()[0].toLowerCase();
                userCommand(cd);
            } while (!_advance);
        } while (!game.playerWins() && !game.playerLooses() && !exit_command(cd));
        // view.showGame();


        view.showEndMessage();
    }

    
    private void userCommand(String cd) {
        if (help_command(cd)) {
            view.showMessage(Arrays.toString(Messages.HELP_LINES));
            _advance=false;
        } else if (reset_command(cd))
            game.reset();
        else if (none_command(cd)) {
            game.update();
        } else {
            view.showMessage(Messages.INVALID_COMMAND);
            _advance=false;
        }
    }

    private boolean exit_command(String comando) {
        return comando.equals("exit") || comando.equals("e");
    }

    private boolean none_command(String comando) {
        return comando.equals("none") || comando.equals("n") || comando.equals("");
    }

    private boolean help_command(String comando) {
        return comando.equals("help") || comando.equals("h");
    }

    private boolean reset_command(String comando) {
        return comando.equals("reset") || comando.equals("r");
    }
}

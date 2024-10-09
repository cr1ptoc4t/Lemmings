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
    private boolean _exit = false;

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
                cd = view.getPrompt()[0].toLowerCase();
            } while (userCommand(cd));
        } while (game.numLemmingsInBoard()>0 && !_exit);

        view.showEndMessage();
    }

    //devuelve false cuando se debe parar el ciclo de juego
    private boolean userCommand(String cd) {
        boolean advance = true;
        if (help_command(cd)) {
            for(int i = 0; i < Messages.HELP_LINES.length; i++)
                view.showMessage(Messages.HELP_LINES[i]);
            //v//iew.showMessage(Arrays.toString(Messages.HELP_LINES));
            advance = false;
        } else if (reset_command(cd)) {
            game.reset();

        } else if (none_command(cd)) {
            game.update();

        } else if(exit_command(cd)){
            advance = false;
            _exit=true;
        }
        else{
            view.showMessage(Messages.INVALID_COMMAND);
            advance = false;
        }
        return !advance && !_exit;
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

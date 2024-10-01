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
        String[] cd;
        do {
            view.showGame();
            cd = view.getPrompt();
            userCommand(cd);
        } while (game.playerWins() || game.playerLooses() || !exit_command(cd));
       // view.showGame();


        view.showEndMessage();
    }

    private void userCommand(String[] cd) {
        if (move_command(cd)) {
            game.update();
        } else if (none_command(cd)) {
            game.update();
        } else if (help_command(cd)) {
            view.showMessage(Arrays.toString(Messages.HELP_LINES));
        }


    }

    private boolean exit_command(String[] comando) {
        return comando[0].toLowerCase().equals("exit") || comando[0].toLowerCase().equals("e");
    }

    private boolean move_command(String[] comando) {
        return comando[0].toLowerCase().equals("move") || comando[0].toLowerCase().equals("m");
    }

    private boolean none_command(String[] comando) {
        return comando[0].toLowerCase().equals("none") || comando[0].toLowerCase().equals("n");
    }

    private boolean help_command(String[] comando) {
        return comando[0].toLowerCase().equals("help") || comando[0].toLowerCase().equals("h");
    }
}

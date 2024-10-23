package tp1.control;

<<<<<<< HEAD
=======
import tp1.control.commands.Command;
import tp1.control.commands.CommandGenerator;
>>>>>>> v2.0
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

<<<<<<< HEAD

/**
 * Accepts user input and coordinates the game execution logic
 */
public class Controller {

    private final Game game;
    private final GameView view;
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
        String[] cd;
        do {
            view.showGame();
            do {
                cd = view.getPrompt();
            } while (userCommand(cd));
        } while (game.numLemmingsInBoard()>0 && !_exit);

        view.showEndMessage();
    }

    //devuelve false cuando se debe parar el ciclo de juego
    private boolean userCommand(String[] str) {
        boolean advance = false;

    	if(str.length>1) {
    		view.showError(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
            
    	}else {
    		String cd = str[0].toString().toLowerCase();
	        if (help_command(cd)) {
                view.showMessage(Messages.HELP_LINES[0]);
	            for(int i = 1; i < Messages.HELP_LINES.length; i++)
	                view.showMessage("\t"+Messages.HELP_LINES[i]);
	            
	        } else if (reset_command(cd)) {
	            game.reset();
	            advance = true;
	        } else if (none_command(cd)) {
	            game.update();
	            advance = true;

	        } else if(exit_command(cd)){
	            _exit=true;
	        }
	        else{
	            view.showError(Messages.UNKNOWN_COMMAND);
	        }
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
=======
/**
 *  Accepts user input and coordinates the game execution logic
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
		String[] words = null;

		view.showWelcome();

		view.showGame();
		while ( !game.isFinished()) {
			words = view.getPrompt();
			Command command = CommandGenerator.parse(words);
			if (command != null)
				command.execute(game, view);
			else
				view.showError(Messages.UNKNOWN_COMMAND.formatted(words[0]));
				//view.showError(Messages.UNKNOWN_COMMAND);

		}
		view.showEndMessage();
	}
>>>>>>> v2.0
}

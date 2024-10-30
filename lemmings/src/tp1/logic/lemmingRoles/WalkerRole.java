package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class WalkerRole {
	private static final String NAME = Messages.WALKER_ROL_NAME;
	private static final String HELP = Messages.WALKER_ROL_HELP;
	private static final String ICON_RIGHT = Messages.LEMMING_RIGHT;
	private static final String ICON_LEFT = Messages.LEMMING_LEFT;
	
	public void play(Lemming lemming) {
		lemming.move();
	}

	public String getIcon(Lemming lemming) {

			String icon="";

			//si la direccion es down, miramos la direccion anterior
			Direction d = lemming.get_dir();
			if(d==Direction.DOWN)
				d=lemming.get_anterior_dir();

			if (d == Direction.RIGHT)
				icon = ICON_RIGHT;
			else if(d == Direction.LEFT)
				icon = ICON_LEFT;


			return icon;


	}

	private String getName() {
		// TODO Auto-generated method stub
		return NAME;
	}

	public String getHelp() {
		return HELP;
	}
	
	// String that represents the object status
	// for this simple class, the name is enough
	@Override
	public String toString() {
		return getName();
	}
}

package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Lemming {
	private Position _pos;
	private boolean _alive;
	private Direction _dir;
	private int _fall;
	private WalkerRole _walker_role;
	private Game _game;

	//TODO fill your code
    public Lemming(Position _pos, boolean _alive, Direction _dir, int _fall, WalkerRole _walker_role, Game _game) {
		this._pos = _pos;
		this._alive = _alive;
	}

	/**
	 * Implements the automatic update
	 */
	public void update() {
		if(_alive){
			_walker_role.play();

		/*
		Comprobar que están vivos
		Delegar en el WalkerRole que llamará al método correspondiente de
		caminar del lemming, el cual realizará las siguientes tareas:

		 */
		}

	}

	public String toString(){
		return Messages.LEMMING_RIGHT;
	}

	public boolean isInPos(Position p){
		return p.equals(_pos);
	}
}

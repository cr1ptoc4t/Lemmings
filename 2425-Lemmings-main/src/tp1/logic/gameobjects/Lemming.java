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
	private boolean _change_dir;

	//TODO fill your code
    public Lemming(Position _pos, Direction _dir, Game _game) {
		this._game=_game;
		this._pos = _pos;
		this._alive = true;
		this._dir=_dir;
		_walker_role=new WalkerRole(_game);
		_fall=0;
		_change_dir=false;
	}

	/**
	 * Implements the automatic update
	 */
	public void update() {
		if(_alive){
			_walker_role.play();
			if(_pos.vertical_border()&&_change_dir){
				_dir=_dir.opposite();
				_change_dir=false;
			}else if (_pos.vertical_border()){
				_change_dir =true;
			}
			_pos.actualiza(_dir);
			/*
			if(_change_dir){
				_pos.actualiza(_dir);
				if(_pos.vertical_border()/*o toca pared){
					_change_dir=false;
				}
			}else{

				_pos.actualiza(_dir);

				_change_dir=true;
			}
			*/
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

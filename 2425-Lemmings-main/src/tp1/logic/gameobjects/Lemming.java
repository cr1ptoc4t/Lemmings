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
    private boolean _changed_dir;
    private Direction _anterior_dir;
    private boolean _falling;

    //TODO fill your code
    public Lemming(Position _pos, Direction _dir, Game _game) {
        this._game = _game;
        this._pos = _pos;
        this._alive = true;
        this._dir = _dir;
        _walker_role = new WalkerRole(_game, this);
        _fall = 0;
        _changed_dir = false;
    }

    private boolean should_change_dir() {
        return _pos.vertical_border() ||
                _game.wall_in_pos(new Wall(Position.left(_pos))) && _dir == Direction.LEFT ||
                _game.wall_in_pos(new Wall(Position.right(_pos))) && _dir == Direction.RIGHT;
    }

    /**
     * Implements the automatic update
     */
    public void update() {
        if (_alive) {
            if (_game.wall_in_pos(new Wall(Position.over(_pos)))) {

                _walker_role.play();
                if (_fall >= Game.MAX_FALL)
                    _alive = false;
                else {
                    if (should_change_dir() && !_changed_dir) {
                        _dir = _dir.opposite();
                        _changed_dir = true;
                    } else if (should_change_dir() && _changed_dir) {
                        _changed_dir = false;
                    }
                    _pos.actualiza(_dir);
                }
                _fall = 0;
                _falling=false;
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
            } else if (!_falling){
                //calcular caida
                _falling = true;_fall=0;
                _pos.actualiza(Direction.DOWN);
            } else if (_falling) {
                _fall++;
                _pos.actualiza(Direction.DOWN);
            }
        }
    }

    public String toString() {
        if(_alive)
            if(_dir==Direction.RIGHT)
               return Messages.LEMMING_RIGHT;
             else return Messages.LEMMING_LEFT;
        else return Messages.LEMMING_DEAD;
    }

    public boolean isInPos(Position p) {
        return p.equals(_pos);
    }

    public boolean isAlive() {
        return _alive;
    }
}

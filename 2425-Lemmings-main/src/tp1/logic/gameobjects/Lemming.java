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

    public Lemming(Position _pos, Direction _dir, Game _game) {
        this._game = _game;
        this._pos = _pos;
        this._alive = true;
        this._dir = _dir;
        _walker_role = new WalkerRole(_game);
        _fall = 0;
        _changed_dir = false;
    }

    private boolean should_change_dir() {
        return _pos.vertical_border() ||
                _game.wall_in_left(_pos) && _dir == Direction.LEFT ||
                _game.wall_in_right(_pos) && _dir == Direction.RIGHT;
    }

    /**
     * Implements the automatic update
     */

    /*
    public void update() {
        if (_alive) {
            if (_game.exit_door_in_pos(new ExitDoor(Position.over(_pos)))) {
                //¿¿
            } else if (_game.wall_in_pos(new Wall(Position.over(_pos)))) {

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
    */
    public void update() {
        if (_alive) {
            _walker_role.play(this);
        }
    }

    // manejo de movimiento


    public String toString() {
        String icon;
        if (_alive) {
            if (_dir == Direction.DOWN) {
                if (_anterior_dir == Direction.RIGHT)
                     icon = Messages.LEMMING_RIGHT;
                else icon = Messages.LEMMING_LEFT;
            } else if (_dir == Direction.RIGHT)
                 icon = Messages.LEMMING_RIGHT;
            else icon = Messages.LEMMING_LEFT;
        }  else  icon = Messages.LEMMING_DEAD;

        return icon;
    }

    public boolean isInPos(Position p) {
        return p.equals(_pos);
    }

    public boolean isAlive() {
        return _alive;
    }

    public void move() {
        if(!_pos.valid_position())
            _alive=false;
        else if (_falling) {
            handle_fall();
            _fall++;
        } else if (!_game.wall_under(_pos)) {
            _falling = true;
            _anterior_dir = _dir;
            _dir = Direction.DOWN;
            _fall++;
            _pos.actualiza(_dir);
        } else
            normal_step();


    }

    private void normal_step() {
        if (should_change_dir() && !_changed_dir) {
            _dir = _dir.opposite();
            _changed_dir = true;
        } else if (should_change_dir() && _changed_dir) {
            _changed_dir = false;
        }
        _pos.actualiza(_dir);
    }


    private void handle_fall() {
        if (_game.wall_under(_pos)) {
            if (_fall >= Game.MAX_FALL)
                _alive = false;
            else {
                _fall = 0;
                _falling = false;
                _dir = _anterior_dir;
                _pos.actualiza(_dir);

            }
        } else
            _pos.actualiza(_dir);
    }

    public Position get_pos() {
        return _pos;
    }
}

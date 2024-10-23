package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
<<<<<<< HEAD
import tp1.logic.roles.WalkerRole;

public class Lemming {
    private final Position _pos;
    private boolean _alive;
    private Direction _dir;
    private int _fall;
    private final WalkerRole _walker_role;
    private final Game _game;
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
        Position next_pos = new Position(_pos);
        next_pos.actualiza(_dir);
            // está fuera del mapa         o        hay una pared
        return !next_pos.valid_position() || _game.wall_in_pos(next_pos);
    }

    /**
     * Implements the automatic update
     */

    public void update() {
        if (_alive) {
            _walker_role.play(this);
        }
    }


    public String toString() {
        return _walker_role.getIcon(this);
    }

    public boolean isInPos(Position p) {
        return p.equals(_pos);
    }

    public boolean isAlive() {
        return _alive;
    }

    public void move() {
        if (!_pos.valid_position())
            _alive = false;
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
        if(should_change_dir()){
            if (_changed_dir) {
                _changed_dir = false;
            } else {
                _dir = _dir.opposite();
                _changed_dir = true;
            }
        }else
        	_pos.actualiza(_dir);
    }


    private void handle_fall() {
        if (_game.wall_under(_pos)) {
            if (_fall > Game.MAX_FALL)
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

    public Direction get_dir() {
        return this._dir;
    }

    public Direction get_dir_anterior() {
        return this._anterior_dir;
    }
=======
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.view.Messages;

public class Lemming extends GameObject {

	WalkerRole role;
	private Direction _dir;
	private Direction _anterior_dir;
	private boolean _alive;
	private boolean _changed_dir;
	private int _fall;
	private boolean _falling;

	public Lemming(Game game, Position pos) {
		super(game, pos);
		this.role = WalkerRole();
		_dir=Direction.RIGHT;
		_alive=true;
		_fall=0;
		_falling=false;
	}

	private WalkerRole WalkerRole() {
		return new WalkerRole();
	}

	// Not mandatory but recommended
	public void walkOrFall() {
		/*
		if(game.isInAir(pos)){
			_anterior_dir=_dir;
			_dir=Direction.DOWN;
			pos.actualiza(_dir);
		}else{
			Position next_pos = new Position(pos);
			next_pos.actualiza(_dir);
			if(game.isWallInPos(next_pos)){
				_dir = _dir.opposite();
			}else{
				//esto no se si tendria que ser un constructor de copia
				pos=next_pos;
			}

		}

		 */
		move();
	}

	public void move() {
		if (!pos.valid_position())
			_alive = false;
		else if (_falling) {
			handle_fall();
			_fall++;
		} else if (game.isInAir(pos)) {
			_falling = true;
			_anterior_dir = _dir;
			_dir = Direction.DOWN;
			_fall++;
			pos.actualiza(_dir);
		} else
			normal_step();


	}

	private void normal_step() {
		if(should_change_dir()){
			if (_changed_dir) {
				_changed_dir = false;
			} else {
				_dir = _dir.opposite();
				_changed_dir = true;
			}
		}else
			pos.actualiza(_dir);
	}

	private boolean should_change_dir() {
		Position next_pos = new Position(pos);
		next_pos.actualiza(_dir);
		// está fuera del mapa         o        hay una pared
		return !next_pos.valid_position() || game.isWallInPos(next_pos);
	}


	private void handle_fall() {
		if (!game.isInAir(pos)) {
			if (_fall > Game.MAX_FALL)
				_alive = false;
			else {
				_fall = 0;
				_falling = false;
				_dir = _anterior_dir;
				pos.actualiza(_dir);
			}
		} else
			pos.actualiza(_dir);
	}

	/**
	 *  Implements the automatic update
	 */
	public void update() {
		if (isAlive())
			role.play(this);
	}
	@Override
	public String getIcon() {
		return this.role.getIcon(this);
	}

	public String toString(){
		return Messages.LEMMING_LEFT;
	}

	public Direction get_dir() {
		return this._dir;
	}
	public Direction get_anterior_dir() {
		return this._anterior_dir;
	}

>>>>>>> v2.0
}

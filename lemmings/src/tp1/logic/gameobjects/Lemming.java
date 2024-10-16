package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
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
}
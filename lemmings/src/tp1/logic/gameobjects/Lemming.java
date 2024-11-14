package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.view.Messages;


public class Lemming extends GameObject {

    private LemmingRole role;
    private Direction _dir;
    private Direction _anterior_dir;
    private boolean _changed_dir;
    private int _fall;
    private boolean _falling;

    public Lemming(Game game, Position pos) {
        super(game, pos);
        this.role = WalkerRole();
        _dir = Direction.RIGHT;
        _anterior_dir=_dir;
        _fall = 0;
        _falling = false;
    }

    private WalkerRole WalkerRole() {
        return new WalkerRole();
    }


    public void fall() {
        _falling = true;
        if(_dir!=Direction.DOWN) {
            _anterior_dir = _dir;
            _dir = Direction.DOWN;
        }
        _fall++;
        pos.actualiza(_dir);
    }


    public void normal_step() {
        if (should_change_dir()) {
            if (_changed_dir) {
                _changed_dir = false;
            } else {
                _dir = _dir.opposite();
                _changed_dir = true;
            }
        } else
            pos.actualiza(_dir);

    }

    private boolean should_change_dir() {
        Position next_pos = new Position(pos);
        next_pos.actualiza(_dir);
        // está fuera del mapa         o        hay una pared
        return !next_pos.valid_position() || game.isWallInPos(next_pos);
    }


    public void handle_fall() {
        if (!game.isInAir(pos)) {
            if (_fall > Game.MAX_FALL)
                isAlive = false;
            else {
                _fall = 0;
                _falling = false;
                _dir = _anterior_dir;
                pos.actualiza(_dir);
            }
        } else {
            pos.actualiza(_dir);
            _fall++;
        }
    }

    /**
     * Implements the automatic update
     */
    public void update() {
        if (isAlive())
            role.play(this);
    }

    @Override
    public String getIcon() {
        return this.role.getIcon(this);
    }

    public String toString() {
        return Messages.LEMMING_LEFT;
    }

    public Direction get_dir() {
        return this._dir;
    }

    public Direction get_anterior_dir() {
        return this._anterior_dir;
    }

    public void disableRole() {
        this.role = new WalkerRole();
    }

    @Override
    public boolean setRole(LemmingRole role) {
        if(role.equals(this.role))
            return false;

        this.role = role;
        return true;
    }

    public boolean exits() {
        if (game.isExitDoorInPos(this)) {
            isAlive = false;
        }
        return !isAlive;
    }

    public boolean isInAir() {
        return game.isInAir(pos);
    }

    public boolean isFalling() {
        return _falling;
    }

    public void handle_no_damage_fall() {
        if (!game.isInAir(pos)) {
            _fall = 0;
            _falling = false;
            _dir = _anterior_dir;
            disableRole();
        }
        normal_step();
    }

    @Override
    public boolean receiveInteraction(GameItem other) {
        return other.interactWith(this);
    }



    public void checkPosition() {
        if (!pos.valid_position()) {
            isAlive = false;
        }
    }

    public void cave(){
        if(_dir!=Direction.DOWN)
            _anterior_dir = _dir;
        _dir = Direction.DOWN;
        pos.actualiza(_dir);
    }

    public boolean can_cave(){
        Position next_pos = new Position(pos);
        next_pos.actualiza(Direction.DOWN);
        return next_pos.valid_position() && game.isWallInPos(next_pos)
                && !game.isMetalInPos(next_pos);
    }

}

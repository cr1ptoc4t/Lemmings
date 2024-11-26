package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.view.Messages;


public class Lemming extends GameObject {

    private LemmingRole role;
    private Direction _dir;
    private Direction _anterior_dir;
    private boolean _changed_dir;
    private int _fall;
    private boolean _falling;

    public Lemming(GameWorld game, Position pos) {
        super(game, pos);
        this.role = WalkerRole();
        _dir = Direction.RIGHT;
        _anterior_dir = _dir;
        _fall = 0;
        _falling = false;
    }

    public Lemming() {
        this.role = WalkerRole();
    }

    public Lemming(GameWorld game, Position pos, Direction dir, int fall, LemmingRole role) {
        super(game, pos);
        this.role = role;
        _dir = dir;
        _anterior_dir = _dir;
        _fall = fall;
        _falling = false;
    }

    private WalkerRole WalkerRole() {
        return new WalkerRole();
    }

    public String getName() {
        return Messages.LEMMING_NAME;
    }

    // caer
    public void fall() {
        _falling = true;
        if (_dir != Direction.DOWN) {
            _anterior_dir = _dir;
            _dir = Direction.DOWN;
        }
        _fall++;
        pos.actualiza(_dir);
    }


    // paso normal (mirando si puede cambiar de lado)
    public void normal_step() {
        if (should_change_dir()) {
            _changed_dir = !_changed_dir;
            _anterior_dir = _dir;
            _dir = _dir.opposite();
        } else
            pos.actualiza(_dir);
    }

    private boolean should_change_dir() {
        Position next_pos = new Position(pos);
        next_pos.actualiza(_dir);
        // está fuera del mapa         o        hay una pared
        return !next_pos.valid_position() || game.isWallInPos(next_pos);
    }


    // cayendo
    public void handle_fall() {
        if (!game.isInAir(pos)) {
            if (_fall > Game.MAX_FALL)
                isAlive = false;
            else {
                _fall = 0;
                _falling = false;
                _dir = _anterior_dir;
                normal_step();
                disableRole();
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
        if (role.equals(this.role))
            return false;

        this.role = role;
        return true;
    }

    //devuelve true si el lemming ha llegado a la puerta de salida
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

    //caida sin daño
    public void handle_no_damage_fall() {
        _fall = 0;
        handle_fall();
    }

    @Override
    public boolean receiveInteraction(GameItem other) {
        return role.receiveInteraction(other, this);
    }

    //en caso de estar fuera del mapa -> muere
    public void checkPosition() {
        if (!pos.valid_position()) {
            isAlive = false;
        }
    }

    //cavar (aqui no rompe el muro, pero la interaccion si)
    public void cave() {
        if (_dir != Direction.DOWN)
            _anterior_dir = _dir;
        _dir = Direction.DOWN;
        pos.actualiza(_dir);
    }

    //comprueba si puede cavar
    public boolean can_cave() {
        Position next_pos = new Position(pos);
        next_pos.actualiza(Direction.DOWN);
        return next_pos.valid_position() && game.isWallInPos(next_pos)
                && !game.isMetalInPos(next_pos);
    }

    @Override
    public boolean interactWith(Lemming lemming) {
        return false;
    }

    @Override
    public boolean interactWith(Wall wall) {
        return true;
    }

    @Override
    public boolean interactWith(ExitDoor door) {
        return role.interactWith(door, this);
    }

    public GameObject parse(String line, GameWorld game) throws ObjectParseException, OffBoardException {
        String[] words = line.trim().split("\\s+");

        if (!words[1].equalsIgnoreCase("Lemming"))
            return null;

        try {
            Position p = new Position(words[0]);
            if (!p.valid_position())
                throw new OffBoardException(Messages.INVALID_POSITION);
            Direction d = Direction.parse(words[2]);

            if(d==null)
                throw new ObjectParseException(String.format(Messages.UNKNOWN_DIRECTION, line));
            if(d==Direction.UP)
                throw new ObjectParseException(String.format(Messages.INVALID_DIRECTION, line));

            int fall = Integer.parseInt(words[3]);
            LemmingRole role = LemmingRoleFactory.parse(words[4]);
            return new Lemming(game, p, d, fall, role);
        } catch (RoleParseException e){
            throw new ObjectParseException(String.format(Messages.INVALID_ROLE, line));
        }
        catch (NumberFormatException e) {
            throw new ObjectParseException(String.format(Messages.INVALID_OBJECT_POSITION, line));
        }

    }
}

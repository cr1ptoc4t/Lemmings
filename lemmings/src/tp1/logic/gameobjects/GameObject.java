package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;

public abstract class GameObject implements GameItem{

	protected Position pos;
	protected boolean isAlive;
	protected GameWorld game;
	
	public GameObject(GameWorld game, Position pos) {
		this.isAlive = true;
		this.pos = pos;
		this.game = game;
	}
	public GameObject(){

	}
	
	public boolean isInPosition(Position p) {
		return this.pos.equals(p);
	}

	public boolean equalPosition(GameItem g){
		return g.isInPosition(this.pos);
	}
 	
	public boolean isAlive() {
		return isAlive;
	}
	public boolean isSolid(){
		return false;
	}
	public boolean isExit(){
		return false;
	}

	// public void update()
	
	public abstract String getIcon();

	public abstract void update() ;
	private Position get_pos() {
		return pos;
	}

	public boolean setRole(LemmingRole role){
		return false;
	}

	public boolean interactWith(Lemming lemming) {
		return false;
	}

	public boolean interactWith(Wall wall) {
		return false;
	}

	public boolean interactWith(ExitDoor door) {
		return false;
	}

	public boolean isMetal() {
		return false;
	}

	public GameObject parse(String line, GameWorld game)
			throws ObjectParseException, OffBoardException {
		throw new ObjectParseException("Error: Invalid object");
	}

	public abstract String getName();
	}

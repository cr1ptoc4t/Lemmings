package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;

public abstract class GameObject implements GameItem{

	protected Position pos;
	protected boolean isAlive;
	protected Game game;
	
	public GameObject(Game game, Position pos) {
		this.isAlive = true;
		this.pos = pos;
		this.game = game;
	}
	
	public boolean isInPosition(Position p) {
		// TODO fill your code here, it should depends on the status of the object
		return this.pos.equals(p);
	}
	/* TODO
	public boolean equalPosition(GameObject g){
		return this.pos.equals(g.get_pos());
	}
	*/
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
}

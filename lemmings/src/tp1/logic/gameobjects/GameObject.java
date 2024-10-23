package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public abstract class GameObject {

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
}

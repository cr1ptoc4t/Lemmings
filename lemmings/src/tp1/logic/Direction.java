package tp1.logic;

import tp1.exceptions.ObjectParseException;

/**
 * Represents the allowed directions in the game
 *
 */
public enum Direction {
	LEFT(-1,0), RIGHT(1,0), DOWN(0,1), UP(0,-1), NONE(0,0);
	
	private final int x;
	private final int y;
	
	private Direction(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	public Direction opposite(){
		Direction dir;
		if(this==Direction.LEFT) dir = Direction.RIGHT;
		else if (this == Direction.RIGHT) dir=Direction.LEFT;
		else dir = null;

		return dir;
	}

	public static Direction parse(String str) {
		for(Direction d : Direction.values())
			if(d.name().equalsIgnoreCase(str))
				return d;

		return null;

	}
	
}

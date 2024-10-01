package tp1.logic;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.WalkerRole;
import tp1.logic.gameobjects.Wall;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private GameObjectContainer _game_object_container;
	public Game(int nLevel) {
		_game_object_container = new GameObjectContainer();
		// TODO Auto-generated constructor stub
	}

	public int getCycle() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsInBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsDead() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsExit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String positionToString(int col, int row) {

		Position position = new Position(col,row);
		String str = _game_object_container.someoneInPos(position);

		return str;
	}

	public boolean playerWins() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean playerLooses() {
		// TODO Auto-generated method stub
		return false;
	}

	public String help() {
		// TODO Auto-generated method stub
		return null;
	}
	public void update(){
		_game_object_container.add(new Lemming(new Position(4,3), true, Direction.RIGHT,0, new WalkerRole(),this));
		_game_object_container.add(new Wall(new Position(4,4)));
		_game_object_container.add(new Wall(new Position(5,4)));

	}

}

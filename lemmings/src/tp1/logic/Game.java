package tp1.logic;

public class Game implements GameStatus{

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;


	private GameObjectContainer _game_object_container;
	private int cycle;
	private final int nLevel;
	public Game(int nLevel) {
		this.nLevel = nLevel;
		_game_object_container = new GameObjectContainer();
		cycle = 0;
	}
	
// GameStatus methods
	@Override
	public int getCycle() {
		return cycle;
	}

	public int numLemmingsInBoard() {
		return _game_object_container.get_nlemmings();
	}

	public int numLemmingsDead() {
		return _game_object_container.get_ndead_lemmings();
	}

	public int numLemmingsExit() {
		return _game_object_container.get_nexit_lemmings();
	}


	@Override
	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String positionToString(int col, int row) {
		return _game_object_container.someoneInPosition(new Position(col, row));
	}

	@Override
	public boolean playerWins() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean playerLooses() {
		// TODO Auto-generated method stub
		return false;
	}

// GameModel methods
	// @Override
	public void update() {
		// TODO Auto-generated method stub

	}
	// @Override
	public void exit() {
		// TODO Auto-generated method stub		
	}
	//@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// TODO Auto-generated method stub
	
// GameWorld methods (callbacks)
	// @Override
	public boolean isInAir(Position pos) {
		// TODO Auto-generated method stub
        return false;
    }

	// @Override
	public void lemmingArrived() {

	}

	public void reset() {
	}
	// TODO Auto-generated method stub
	
// Other methods
	// TODO you should write a toString method to return the string that represents the object status
	// @Override
	// public String toString()
}

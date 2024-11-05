package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.lemmingRoles.LemmingRole;

<<<<<<< HEAD
public class Game {
=======
public class Game implements GameStatus{
>>>>>>> v2.0

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	public static final int MAX_FALL = 3;
<<<<<<< HEAD
	private int cycle;
	private final int _level;

=======
>>>>>>> v2.0
	private static final int _LEMMINGS_MIN_GAME_0 = 2;
	private static final int _LEMMINGS_MIN_GAME_1 = 2;
	private static final int _LEMMINGS_MIN_GAME_2 = 2;
	private static final int _LEMMINGS_MIN_GAME_3 = 2;
<<<<<<< HEAD
	private int _lemmings_min;

	private GameObjectContainer _game_object_container;
	public Game(int nLevel) {
		this._game_object_container = new GameObjectContainer();
		this._level =nLevel;
		this.cycle=0;
=======
	private static final int _LEMMINGS_GAME_1 = 4;
	private static final int _LEMMINGS_GAME_2 = 3;
	private int _lemmings_min;
	private int _lemmings_alive;


	private GameObjectContainer _game_object_container;
	private int cycle;
	private final int nLevel;
	public Game(int nLevel) {
		this.nLevel = nLevel;
		_game_object_container = new GameObjectContainer();
		cycle = 0;
>>>>>>> v2.0
		chooseLevel();
	}

	private void chooseLevel() {
<<<<<<< HEAD
		switch (_level){
=======
		switch (nLevel){
>>>>>>> v2.0
			case 0:
				initGame0();
				break;
			case 1:
				initGame1();
				break;
			case 2:
				initGame2();
			default:
				initGame0();
		}
		_game_object_container.set_lemmings(_lemmings_alive);
	}

<<<<<<< HEAD
	private void initGame0() {
		_lemmings_min=_LEMMINGS_MIN_GAME_0;

		_game_object_container.add(new Lemming(new Position(3,3), Direction.RIGHT,this));
		_game_object_container.add(new Lemming(new Position(0,8), Direction.RIGHT,this));
		_game_object_container.add(new Lemming(new Position(9,0), Direction.RIGHT,this));
		
		_game_object_container.add(new ExitDoor(new Position(4,5)));

		_game_object_container.add(new Wall(new Position(0,9)));
		_game_object_container.add(new Wall(new Position(1,9)));
		_game_object_container.add(new Wall(new Position(2,4)));
		_game_object_container.add(new Wall(new Position(3,4)));
		_game_object_container.add(new Wall(new Position(4,4)));
		_game_object_container.add(new Wall(new Position(4,6)));
		_game_object_container.add(new Wall(new Position(5,6)));
		_game_object_container.add(new Wall(new Position(6,6)));
		_game_object_container.add(new Wall(new Position(7,6)));
		_game_object_container.add(new Wall(new Position(7,5)));
		_game_object_container.add(new Wall(new Position(8,8)));
		_game_object_container.add(new Wall(new Position(8,1)));
		_game_object_container.add(new Wall(new Position(8,9)));
		_game_object_container.add(new Wall(new Position(9,1)));
		_game_object_container.add(new Wall(new Position(9,9)));
=======
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
		return _lemmings_min;
	}


	@Override
	public String positionToString(int col, int row) {
		return _game_object_container.someoneInPosition(new Position(col, row));
	}

	@Override
	public boolean playerWins() {
		return _game_object_container.get_nlemmings()==0
				&&_game_object_container.get_nexit_lemmings() >= _lemmings_min;
	}

	@Override
	public boolean playerLooses() {
		return _game_object_container.get_nlemmings()==0
				&& _game_object_container.get_nexit_lemmings() < _lemmings_min;
	}

// GameModel methods
	// @Override
	public void update() {
		//_game_object_container.procesaExit();
		_game_object_container.update();
		_game_object_container.procesaMuertosExit();

		cycle++;
	}
	// @Override
	public void exit() {
		// TODO Auto-generated method stub		
	}
	//@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return _game_object_container.get_nlemmings() == 0;
	}
	
	// TODO Auto-generated method stub
	
// GameWorld methods (callbacks)
	// @Override
	public boolean isInAir(Position pos) {
        return !_game_object_container.solidInPos(Position.debajo(pos));
    }

	// @Override
	public void lemmingArrived() {

	}

	public void reset() {
		_game_object_container= new GameObjectContainer();
		chooseLevel();
		cycle=0;

	}
	// TODO Auto-generated method stub
	
// Other methods
	// TODO you should write a toString method to return the string that represents the object status
	// @Override
	// public String toString()


	//-- mapas
	private void initGame0() {
		_lemmings_min=_LEMMINGS_MIN_GAME_0;
		_lemmings_alive=_LEMMINGS_GAME_2;
		_game_object_container.add(new Lemming(this, new Position(3,3)));
		_game_object_container.add(new Lemming(this, new Position(0,8)));
		_game_object_container.add(new Lemming(this, new Position(9,0)));

		_game_object_container.add(new ExitDoor(this, new Position(4,5)));

		_game_object_container.add(new Wall(this, new Position(0,9)));
		_game_object_container.add(new Wall(this, new Position(1,9)));
		_game_object_container.add(new Wall(this, new Position(2,4)));
		_game_object_container.add(new Wall(this,new Position(3,4)));
		_game_object_container.add(new Wall(this,new Position(4,4)));
		_game_object_container.add(new Wall(this,new Position(4,6)));
		_game_object_container.add(new Wall(this, new Position(5,6)));
		_game_object_container.add(new Wall(this, new Position(6,6)));
		_game_object_container.add(new Wall(this, new Position(7,6)));
		_game_object_container.add(new Wall(this, new Position(7,5)));
		_game_object_container.add(new Wall(this, new Position(8,8)));
		_game_object_container.add(new Wall(this, new Position(8,1)));
		_game_object_container.add(new Wall(this, new Position(8,9)));
		_game_object_container.add(new Wall(this, new Position(9,1)));
		_game_object_container.add(new Wall(this, new Position(9,9)));
>>>>>>> v2.0
	}

	private void initGame1() {
		_lemmings_min=_LEMMINGS_MIN_GAME_1;
<<<<<<< HEAD

		_game_object_container.add(new Lemming(new Position(3,3), Direction.RIGHT,this));
		_game_object_container.add(new Lemming(new Position(2,3), Direction.RIGHT,this));
		_game_object_container.add(new Lemming(new Position(0,8), Direction.RIGHT,this));
		_game_object_container.add(new Lemming(new Position(9,0), Direction.RIGHT,this));

		_game_object_container.add(new ExitDoor(new Position(4,5)));
		
		_game_object_container.add(new Wall(new Position(0,9)));
		_game_object_container.add(new Wall(new Position(1,9)));
		_game_object_container.add(new Wall(new Position(2,4)));
		_game_object_container.add(new Wall(new Position(3,4)));
		_game_object_container.add(new Wall(new Position(4,4)));
		_game_object_container.add(new Wall(new Position(4,6)));
		_game_object_container.add(new Wall(new Position(5,6)));
		_game_object_container.add(new Wall(new Position(6,6)));
		_game_object_container.add(new Wall(new Position(7,6)));
		_game_object_container.add(new Wall(new Position(7,5)));
		_game_object_container.add(new Wall(new Position(8,8)));
		_game_object_container.add(new Wall(new Position(8,1)));
		_game_object_container.add(new Wall(new Position(8,9)));
		_game_object_container.add(new Wall(new Position(9,1)));
		_game_object_container.add(new Wall(new Position(9,9)));
=======
		_lemmings_alive =_LEMMINGS_GAME_1;

		_game_object_container.add(new Lemming(this, new Position(2,3)));
		_game_object_container.add(new Lemming(this, new Position(0,8)));
		_game_object_container.add(new Lemming(this, new Position(3,3)));
		_game_object_container.add(new Lemming(this, new Position(9,0)));

		_game_object_container.add(new ExitDoor(this, new Position(4,5)));

		_game_object_container.add(new Wall(this, new Position(0,9)));
		_game_object_container.add(new Wall(this, new Position(1,9)));
		_game_object_container.add(new Wall(this, new Position(2,4)));
		_game_object_container.add(new Wall(this, new Position(3,4)));
		_game_object_container.add(new Wall(this, new Position(4,4)));
		_game_object_container.add(new Wall(this, new Position(4,6)));
		_game_object_container.add(new Wall(this, new Position(5,6)));
		_game_object_container.add(new Wall(this, new Position(6,6)));
		_game_object_container.add(new Wall(this, new Position(7,6)));
		_game_object_container.add(new Wall(this, new Position(7,5)));
		_game_object_container.add(new Wall(this, new Position(8,8)));
		_game_object_container.add(new Wall(this, new Position(8,1)));
		_game_object_container.add(new Wall(this, new Position(8,9)));
		_game_object_container.add(new Wall(this, new Position(9,1)));
		_game_object_container.add(new Wall(this, new Position(9,9)));

>>>>>>> v2.0
	}




	private void initGame2() {
<<<<<<< HEAD
=======
		/*
>>>>>>> v2.0
		_lemmings_min=_LEMMINGS_MIN_GAME_2;
		_game_object_container.add(new ExitDoor(new Position(4, 5)));
		_game_object_container.add(new Lemming(new Position(4,3), Direction.LEFT,this));
		//_game_object_container.add(new Lemming(new Position(5,3), Direction.RIGHT,this));
		_game_object_container.add(new Wall(new Position(4,4)));
		_game_object_container.add(new Wall(new Position(5,4)));
		_game_object_container.add(new Wall(new Position(2,7)));
		_game_object_container.add(new Wall(new Position(1,7)));
		_game_object_container.add(new Wall(new Position(6,4)));
		_game_object_container.add(new Wall(new Position(0,6)));
		_game_object_container.add(new Wall(new Position(7,4)));
		_game_object_container.add(new Wall(new Position(8,2)));
		_game_object_container.add(new Wall(new Position(3,5)));
		_game_object_container.add(new Wall(new Position(1,9)));


		_game_object_container.add(new ExitDoor(new Position(8,8)));
<<<<<<< HEAD
	}

	private void init_game_3(){
=======

		 */
	}

	private void init_game_3(){

		/*
>>>>>>> v2.0
		_lemmings_min=_LEMMINGS_MIN_GAME_3;
		_game_object_container.add(new Lemming(new Position(4,0), Direction.LEFT,this));

		_game_object_container.add(new Wall(new Position(0, 2)));
		_game_object_container.add(new Wall(new Position(5, 4)));
		_game_object_container.add(new Wall(new Position(1, 3)));
		_game_object_container.add(new Wall(new Position(2, 3)));
		_game_object_container.add(new Wall(new Position(3, 3)));
		_game_object_container.add(new Wall(new Position(4, 3)));
		_game_object_container.add(new Wall(new Position(3, 6)));
		_game_object_container.add(new Wall(new Position(4, 1)));
		_game_object_container.add(new Wall(new Position(4, 9)));
		_game_object_container.add(new Wall(new Position(5, 7)));
		_game_object_container.add(new Wall(new Position(6, 2)));
		_game_object_container.add(new Wall(new Position(7, 7)));
		_game_object_container.add(new Wall(new Position(9, 5)));
		_game_object_container.add(new ExitDoor(new Position(8,8)));
<<<<<<< HEAD

	}

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

	public int numLemmingsToWin() {
		return _lemmings_min;
	}
	public String positionToString(int col, int row) {
		return _game_object_container.someoneInPos(new Position(col,row));
	}

	public boolean playerWins() {
		return numLemmingsExit()>=_lemmings_min;
	}

	public boolean playerLooses() {
		return numLemmingsExit()<_lemmings_min
				&& numLemmingsInBoard()==0;
	}


	public void update(){

		_game_object_container.procesaExit();
		_game_object_container.update();
		_game_object_container.procesaMuertos();

		cycle++;
	}

	public void reset() {
		_game_object_container = new GameObjectContainer();
		cycle=0;
		chooseLevel();
	}

	public boolean wall_in_pos(Position p) {
		return _game_object_container.isWallInPos(p);
	}

	public boolean wall_under(Position p){
		Position debajo = new Position (p);
		debajo.actualiza(Direction.DOWN);

		return _game_object_container.isWallInPos(debajo);
=======
*/
	}


	public boolean isWallInPos(Position position) {
		return _game_object_container.solidInPos(position);
>>>>>>> v2.0
	}

	public boolean isExitDoorInPos(GameObject g) {
		return _game_object_container.isInExit(g);
	}

	public void setRole(LemmingRole role, Position pos) {
		_game_object_container.setRole(role, pos);
	}
}

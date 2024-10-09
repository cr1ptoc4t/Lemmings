package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.WalkerRole;
import tp1.logic.gameobjects.Wall;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	public static final int MAX_FALL = 3;
	int cycle=0;
	private int _level;

	private GameObjectContainer _game_object_container;
	public Game(int nLevel) {
		_game_object_container = new GameObjectContainer();
		this._level =nLevel;
		chooseLevel();
	}

	private void chooseLevel() {
		switch (_level){
			case 0:
				initGame0();
				break;
			case 1:
				initGame1();
				break;
			default:
				default_game();
		}
	}

	private void initGame1() {
		_game_object_container.add(new Lemming(new Position(3,3), Direction.RIGHT,this));
		_game_object_container.add(new Lemming(new Position(2,3), Direction.RIGHT,this));
		_game_object_container.add(new ExitDoor(new Position(4,5)));
		_game_object_container.add(new Lemming(new Position(9,0), Direction.RIGHT,this));
		_game_object_container.add(new Wall(new Position(0,9)));
		_game_object_container.add(new Wall(new Position(1,9)));
		_game_object_container.add(new Wall(new Position(2,4)));
		_game_object_container.add(new Wall(new Position(3,4)));
		_game_object_container.add(new Wall(new Position(4,4)));
		_game_object_container.add(new Wall(new Position(4,6)));
		_game_object_container.add(new Wall(new Position(5,6)));
		_game_object_container.add(new Wall(new Position(6,6)));
		_game_object_container.add(new Wall(new Position(6,6)));
		_game_object_container.add(new Wall(new Position(7,6)));
		_game_object_container.add(new Wall(new Position(7,5)));
		_game_object_container.add(new Wall(new Position(8,8)));
		_game_object_container.add(new Wall(new Position(8,1)));
		_game_object_container.add(new Wall(new Position(8,9)));
		_game_object_container.add(new Wall(new Position(9,1)));
		_game_object_container.add(new Wall(new Position(9,9)));
	}

	private void initGame0() {
		_game_object_container.add(new Lemming(new Position(3,3), Direction.RIGHT,this));
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
		_game_object_container.add(new Wall(new Position(6,6)));
		_game_object_container.add(new Wall(new Position(7,6)));
		_game_object_container.add(new Wall(new Position(7,5)));
		_game_object_container.add(new Wall(new Position(8,8)));
		_game_object_container.add(new Wall(new Position(8,1)));
		_game_object_container.add(new Wall(new Position(8,9)));
		_game_object_container.add(new Wall(new Position(9,1)));
		_game_object_container.add(new Wall(new Position(9,9)));
	}


	private void default_game() {
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
	}

	private void default_game_2(){
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
		_game_object_container.procesaMuertos();
		_game_object_container.procesaExit();
		_game_object_container.update();
		cycle++;
	}

	public void reset() {
		_game_object_container=new GameObjectContainer();
		default_game();
	}

	public boolean wall_in_pos(Position p) {
		return _game_object_container.isWallInPos(p);
	}

	public boolean exit_door_in_pos(Position p) {
		return _game_object_container.isExitDoorInPos(p);
	}
	public boolean wall_under(Position p){
		return _game_object_container.isWallInPos(Position.over(p));
	}

	public boolean wall_in_left(Position pos) {
		return _game_object_container.isWallInPos(Position.left(pos));
	}
	public boolean wall_in_right(Position pos) {
		return _game_object_container.isWallInPos(Position.right(pos));
	}
}

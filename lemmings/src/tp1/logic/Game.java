package tp1.logic;

import tp1.exceptions.*;
import tp1.logic.gameobjects.*;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.view.GameView;
import tp1.view.Messages;

import javax.swing.text.View;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game implements GameModel, GameStatus, GameWorld {

    public static final int DIM_X = 10;
    public static final int DIM_Y = 10;
    public static final int MAX_FALL = 3;

    private static final int _LEMMINGS_MIN_GAME_0 = 2;
    private static final int _LEMMINGS_MIN_GAME_1 = 2;
    private static final int _LEMMINGS_MIN_GAME_2 = 2;
    private static final int _LEMMINGS_MIN_GAME_3 = 1;
    private static final int _LEMMINGS_GAME_0 = 3;
    private static final int _LEMMINGS_GAME_1 = 4;
    private static final int _LEMMINGS_GAME_2 = 6;
    private static final int _LEMMINGS_GAME_3 = 2;

    private int _lemmings_min;
    private int _initial_lemmings;


    private GameObjectContainer _game_object_container;
    private int cycle;
    private final int nLevel;

    private boolean exit = false;
    private String config ;

    public Game(int nLevel) {
        this.nLevel = nLevel;
        _game_object_container = new GameObjectContainer();
        cycle = 0;
        chooseLevel();
    }

    private void chooseLevel() {
        switch (nLevel) {
            case 0:
                initGame0();
                break;
            case 1:
                initGame1();
                break;
            case 2:
                initGame2();
                break;
            case 3:
                initGame3();
                break;
            default:
                initGame0();
        }
        _game_object_container.set_lemmings(_initial_lemmings);
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
        return _lemmings_min;
    }


    @Override
    public String positionToString(int col, int row) {
        return _game_object_container.someoneInPosition(new Position(col, row));
    }

    @Override
    public boolean playerWins() {
        return _game_object_container.get_nlemmings() == 0
                && _game_object_container.get_nexit_lemmings() >= _lemmings_min;
    }

    @Override
    public boolean playerLooses() {
        return _game_object_container.get_nlemmings() == 0
                && _game_object_container.get_nexit_lemmings() < _lemmings_min;
    }

    // GameModel methods
    // @Override
    public void update() {
        _game_object_container.update();
        _game_object_container.procesaMuertosExit();
        cycle++;
    }

    // @Override
    public void exit() {
        exit = true;
    }

    //@Override
    public boolean isFinished() {
        return _game_object_container.get_nlemmings() == 0 || exit;
    }


    // GameWorld methods (callbacks)
    // @Override
    public boolean isInAir(Position pos) {
        return !_game_object_container.solidInPos(Position.debajo(pos));
    }

    public void reset() throws CommandExecuteException {
        if(config == null) {
            _game_object_container = new GameObjectContainer();
            chooseLevel();
            cycle = 0;
        } else{
            try {
                load(config);
            } catch (GameLoadException e) {
                throw new CommandExecuteException(e.getMessage());
            }
        }
    }


    //-- mapas
    private void initGame0() {
        _lemmings_min = _LEMMINGS_MIN_GAME_0;
        _initial_lemmings = _LEMMINGS_GAME_0;
        _game_object_container.add(new ExitDoor(this, new Position(4, 5)));

        _game_object_container.add(new Lemming(this, new Position(2, 3)));
        _game_object_container.add(new Lemming(this, new Position(0, 8)));
        _game_object_container.add(new Lemming(this, new Position(9, 0)));


        _game_object_container.add(new Wall(this, new Position(0, 9)));
        _game_object_container.add(new Wall(this, new Position(1, 9)));
        _game_object_container.add(new Wall(this, new Position(2, 4)));
        _game_object_container.add(new Wall(this, new Position(3, 4)));
        _game_object_container.add(new Wall(this, new Position(4, 4)));
        _game_object_container.add(new Wall(this, new Position(4, 6)));
        _game_object_container.add(new Wall(this, new Position(5, 6)));
        _game_object_container.add(new Wall(this, new Position(6, 6)));
        _game_object_container.add(new Wall(this, new Position(7, 6)));
        _game_object_container.add(new Wall(this, new Position(7, 5)));
        _game_object_container.add(new Wall(this, new Position(8, 8)));
        _game_object_container.add(new Wall(this, new Position(8, 1)));
        _game_object_container.add(new Wall(this, new Position(8, 9)));
        _game_object_container.add(new Wall(this, new Position(9, 1)));
        _game_object_container.add(new Wall(this, new Position(9, 9)));
    }

    private void initGame1() {
        _lemmings_min = _LEMMINGS_MIN_GAME_1;
        _initial_lemmings = _LEMMINGS_GAME_1;
        _game_object_container.add(new ExitDoor(this, new Position(4, 5)));

        _game_object_container.add(new Lemming(this, new Position(2, 3)));
        _game_object_container.add(new Lemming(this, new Position(0, 8)));
        _game_object_container.add(new Lemming(this, new Position(3, 3)));
        _game_object_container.add(new Lemming(this, new Position(9, 0)));


        _game_object_container.add(new Wall(this, new Position(0, 9)));
        _game_object_container.add(new Wall(this, new Position(1, 9)));
        _game_object_container.add(new Wall(this, new Position(2, 4)));
        _game_object_container.add(new Wall(this, new Position(3, 4)));
        _game_object_container.add(new Wall(this, new Position(4, 4)));
        _game_object_container.add(new Wall(this, new Position(4, 6)));
        _game_object_container.add(new Wall(this, new Position(5, 6)));
        _game_object_container.add(new Wall(this, new Position(6, 6)));
        _game_object_container.add(new Wall(this, new Position(7, 6)));
        _game_object_container.add(new Wall(this, new Position(7, 5)));
        _game_object_container.add(new Wall(this, new Position(8, 8)));
        _game_object_container.add(new Wall(this, new Position(8, 1)));
        _game_object_container.add(new Wall(this, new Position(8, 9)));
        _game_object_container.add(new Wall(this, new Position(9, 1)));
        _game_object_container.add(new Wall(this, new Position(9, 9)));

    }


    private void initGame2() {

        _lemmings_min = _LEMMINGS_MIN_GAME_2;
        _initial_lemmings = _LEMMINGS_GAME_2;
        _game_object_container.add(new Lemming(this, new Position(2, 3)));
        _game_object_container.add(new Lemming(this, new Position(3, 3)));
        _game_object_container.add(new Lemming(this, new Position(0, 8)));
        _game_object_container.add(new Lemming(this, new Position(9, 0)));
        _game_object_container.add(new Lemming(this, new Position(6, 0)));

        Lemming parachuter = new Lemming(this, new Position(6, 0));
        try {
            parachuter.setRole(LemmingRoleFactory.parse(Messages.PARACHUTE_ROL_NAME));
        } catch (RoleParseException e) {

        }
        _game_object_container.add(parachuter);


        _game_object_container.add(new ExitDoor(this, new Position(4, 5)));
        //walls
        _game_object_container.add(new Wall(this, new Position(0, 9)));
        _game_object_container.add(new Wall(this, new Position(1, 9)));
        _game_object_container.add(new Wall(this, new Position(2, 4)));
        _game_object_container.add(new Wall(this, new Position(3, 4)));
        _game_object_container.add(new Wall(this, new Position(3, 5)));
        _game_object_container.add(new MetalWall(this, new Position(3, 6)));
        _game_object_container.add(new Wall(this, new Position(4, 4)));
        _game_object_container.add(new Wall(this, new Position(4, 6)));
        _game_object_container.add(new Wall(this, new Position(5, 6)));
        _game_object_container.add(new Wall(this, new Position(6, 6)));
        _game_object_container.add(new Wall(this, new Position(7, 6)));
        _game_object_container.add(new Wall(this, new Position(7, 5)));

        _game_object_container.add(new Wall(this, new Position(8, 1)));
        _game_object_container.add(new Wall(this, new Position(9, 1)));
        _game_object_container.add(new Wall(this, new Position(8, 8)));
        _game_object_container.add(new Wall(this, new Position(8, 9)));
        _game_object_container.add(new Wall(this, new Position(9, 9)));

    }

    private void initGame3() {

        _lemmings_min = _LEMMINGS_MIN_GAME_3;
        _initial_lemmings = _LEMMINGS_GAME_3;
        _game_object_container.add(new Lemming(this, new Position(2, 3)));

        Lemming parachuter = new Lemming(this, new Position(6, 0));
        try {
            parachuter.setRole(LemmingRoleFactory.parse("Parachuter"));
        } catch (Exception e) {
        }
        _game_object_container.add(parachuter);


        _game_object_container.add(new ExitDoor(this, new Position(4, 5)));
        //walls
        _game_object_container.add(new Wall(this, new Position(0, 9)));
        _game_object_container.add(new Wall(this, new Position(1, 9)));
        _game_object_container.add(new Wall(this, new Position(2, 4)));
        _game_object_container.add(new Wall(this, new Position(3, 4)));
        _game_object_container.add(new Wall(this, new Position(3, 5)));
        _game_object_container.add(new MetalWall(this, new Position(3, 6)));
        _game_object_container.add(new Wall(this, new Position(4, 4)));
        _game_object_container.add(new Wall(this, new Position(4, 6)));
        _game_object_container.add(new Wall(this, new Position(5, 6)));
        _game_object_container.add(new Wall(this, new Position(6, 6)));
        _game_object_container.add(new Wall(this, new Position(7, 6)));
        _game_object_container.add(new Wall(this, new Position(7, 5)));

        _game_object_container.add(new Wall(this, new Position(8, 1)));
        _game_object_container.add(new Wall(this, new Position(9, 1)));
        _game_object_container.add(new Wall(this, new Position(8, 8)));
        _game_object_container.add(new Wall(this, new Position(8, 9)));
        _game_object_container.add(new Wall(this, new Position(9, 9)));

    }

    public boolean isWallInPos(Position position) {
        return _game_object_container.solidInPos(position);
    }

    public boolean isMetalInPos(Position position) {
        return _game_object_container.metalInPos(position);
    }

    public boolean isExitDoorInPos(GameObject g) {
        return _game_object_container.isInExit(g);
    }

    public boolean setRole(LemmingRole role, Position pos) throws OffBoardException {
        if (!pos.valid_position())
            throw new OffBoardException(String.format(Messages.EXC_OFF_BOARD, pos.toString()));

        return (_game_object_container.setRole(role, pos));
    }

    public void load(String filename) throws GameLoadException {
        try {
            readFromFile(filename);
            config = filename;
        } catch (FileNotFoundException e) {
            throw new GameLoadException(String.format(Messages.FILE_NOT_FOUND, filename), null);
        }
    }

    public void readFromFile(String filename) throws FileNotFoundException, GameLoadException {
        Scanner s;
        try {
            s = new Scanner(new BufferedReader(new FileReader(filename)));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(String.format(Messages.FILE_NOT_FOUND, filename));
        }
        String line = s.nextLine();

        //procesar cabecera
        procesaCabecera(s, line);

        //procesar resto lineas
        try {
            while (s.hasNextLine()) {
                line = s.nextLine();
                procesaLineaGenerica(s, line);
            }
        } catch (OffBoardException e) {
            throw new GameLoadException(String.format(Messages.OBJ_POS_OFF, line), e);
        } catch (ObjectParseException e){
            throw new GameLoadException(e.getMessage());
        }
        s.close();
    }

    private void procesaLineaGenerica(Scanner s, String line) throws OffBoardException, ObjectParseException {
        GameObject g = GameObjectFactory.parse(line, this);
        _game_object_container.add(g);
    }

    private void procesaCabecera(Scanner s, String line) throws GameLoadException {
        //line = s.nextLine();
        String[] words = line.trim().split("\\s+");

        if(words.length != 5)
            throw new GameLoadException(String.format(Messages.INCORRECT_GAME_STATUS, line));

        try {
            cycle = Integer.parseInt(words[0]);
            _lemmings_min = Integer.parseInt(words[4]);

            _game_object_container.setNewGame(Integer.parseInt(words[1]),Integer.parseInt(words[2]), Integer.parseInt(words[3]));
        } catch (NumberFormatException e) {
            throw new GameLoadException(String.format(Messages.INCORRECT_GAME_STATUS, line), e);
        }
    }

    public void save(String fileName, GameView view) throws GameModelException {
        try{
            PrintWriter writer = new PrintWriter(new File(fileName));
            writer.println(view.toString());
            writer.close();
        }catch (FileNotFoundException e){
            throw new GameModelException(e.getMessage());
        }
    }

}

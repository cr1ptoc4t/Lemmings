package tp1.logic.roles;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class WalkerRole {

    private final Game _game;

    public WalkerRole(Game game) {
        this._game = game;
    }

    public void play(Lemming l) {
        l.move();
    }

    public String getIcon(Lemming l) {
        String icon="";

        //si la direccion es down, miramos la direccion anterior
        Direction d = l.get_dir();
        if(d==Direction.DOWN)
            d=l.get_dir_anterior();

        if (d == Direction.RIGHT)
            icon = Messages.LEMMING_RIGHT;
        else if(d == Direction.LEFT)
            icon = Messages.LEMMING_LEFT;


        return icon;
    }


}
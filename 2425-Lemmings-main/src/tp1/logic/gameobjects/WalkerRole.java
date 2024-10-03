package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.view.Messages;

public class WalkerRole {
    private Game _game;
    public WalkerRole(Game game){
        this._game=game;
    }
    public void play( ) {
/*
        Si están cayendo gestionar la caída. En particular, morir si alcanzan el suelo tras una caída demasiado grande.
                Si no están cayendo pero están en el aire tendrán que caer.
                Si no se dan ninguna de las situaciones anterirores dar un paso normal. El paso consistirá en avanzar o cambiar de dirección.

         */


    }
    @Override
    public String toString( ) {
        return Messages.LEMMING_RIGHT;
    }
}

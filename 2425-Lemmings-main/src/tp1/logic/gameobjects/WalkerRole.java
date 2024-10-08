package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class WalkerRole {

    private Game _game;

    public WalkerRole(Game game) {
        this._game = game;
    }

    public void play(Lemming l) {
        l.move();
    }

        @Override
    public String toString() {
        return Messages.LEMMING_RIGHT;
    }


}

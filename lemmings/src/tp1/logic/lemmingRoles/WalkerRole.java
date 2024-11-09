package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class WalkerRole extends AbstractRole {

    @Override
    public void start(Lemming lemming) {

    }

    public void play(Lemming lemming) {
        if (!lemming.dies()) {
            if (lemming.isFalling())
                lemming.handle_fall();
            else if (lemming.isInAir())
                lemming.fall();
            else
                lemming.normal_step();

            lemming.checkPosition();
        }
    }

    public String getIcon(Lemming lemming) {

        String icon = "";
        //si la direccion es down, miramos la direccion anterior
        Direction d = lemming.get_dir();
        if (d == Direction.DOWN)
            d = lemming.get_anterior_dir();

        if (d == Direction.RIGHT)
            icon = Messages.LEMMING_RIGHT;
        else if (d == Direction.LEFT)
            icon = Messages.LEMMING_LEFT;


        return icon;


    }


    @Override
    public String getName() {
        return Messages.WALKER_ROL_NAME;
    }

    @Override
    public String getShortcut() {
        return Messages.WALKER_ROL_SHORTCUT;
    }



    @Override
    public boolean interactWith(ExitDoor door, Lemming lemming) {
        return false;
    }

    public String getHelp() {
        return Messages.WALKER_ROL_HELP;
    }

    // String that represents the object status
    // for this simple class, the name is enough
    @Override
    public String toString() {
        return getName();
    }
}

package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public abstract class AbstractRole implements LemmingRole{
    public void start( Lemming lemming ){}
    public void play( Lemming lemming ){ }

    public String getIcon(Lemming lemming) {
        return null;
    }

    public String getName(){
        return null;
    }
    public String getHelp(){
        return null;
    }
    public String getShortcut(){
        return null;
    }

    public boolean receiveInteraction(GameItem other, Lemming lemming){
        return false;
    }

    public boolean interactWith(Lemming receiver, Lemming lemming){
        return false;
    }
    public boolean interactWith(Wall wall, Lemming lemming){
        return false;
    }
    public boolean interactWith(ExitDoor door, Lemming lemming){
        return false;
    }
}

package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public interface LemmingRole  {
    public void start( Lemming lemming );
    public void play( Lemming lemming );
    public String getIcon( Lemming lemming );

    public String getName();
    public String getHelp();
    public String getShortcut();

    public boolean receiveInteraction(GameItem other, Lemming lemming);

    public boolean interactWith(Lemming receiver, Lemming lemming);
    public boolean interactWith(Wall wall, Lemming lemming);
    public boolean interactWith(ExitDoor door, Lemming lemming);

    public default boolean equals(LemmingRole role){
        return this.getName().equals(role.getName());
    }

    public LemmingRole copia();
}

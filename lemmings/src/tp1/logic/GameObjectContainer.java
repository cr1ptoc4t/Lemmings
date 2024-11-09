package tp1.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.lemmingRoles.LemmingRole;

public class GameObjectContainer {
	private List<GameObject> objects;

	public GameObjectContainer() {
		objects = new ArrayList<GameObject>();
	}
	private int _lemmings, _dead_lemmings, _exit_lemmings;
	// Only one add method (polymorphism)
	public void add(GameObject object) {
		if(object!= null) {
			objects.add(object);
		}
	}

	public String someoneInPosition(Position p) {
		String str = "";
		for(GameObject object: objects) {
			if(object.isInPosition(p))
				str += object.getIcon();
		}
		return str;
	}

	public void set_lemmings(int n){
		_lemmings = n;
	}

	public int get_nexit_lemmings() {
		return _exit_lemmings;
	}

	public int get_ndead_lemmings() {
		return _dead_lemmings;
	}

	public int get_nlemmings() {
		return _lemmings;
	}

	public void update() {
		for(GameObject object: objects) {
			object.update();
		}
	}

	public void procesaMuertosExit(){
		int i=0;
		//recorremos array de objetos
		while(i<objects.size()){
			GameObject g = objects.get(i);

			//si el objeto no esta vivo y no es la salida
			if(!g.isExit()&&!g.isAlive()){
				//eliminamos y notificamos según salida o muerte
				objects.remove(i);

				if(isInExit(g)) { notifyLemmingExit();}
				else 			{ notifyLemmingDead();}
			} else{  i++; }
		}
	}

	// TODO you should write a toString method to return the string that represents the object status
	// @Override
	// public String toString()

	public void notifyLemmingExit() {
		_exit_lemmings++;
		_lemmings--;
	}

	public void notifyLemmingDead() {
		_dead_lemmings++;
		_lemmings--;
	}

	public boolean solidInPos(Position pos) {
		int i=0;
		while (i< objects.size() &&
				!(objects.get(i).isInPosition(pos) && objects.get(i).isSolid()))
			i++;
		return i!=objects.size();
	}

	public boolean isInExit(GameObject g){

		//buscamos la salida
		int i=0;
		while(i < objects.size()&& !objects.get(i).isExit()) {
			i++;
		}
		if(i==objects.size()) return false;
		else return objects.get(i).equalPosition(g);
	}

    public void setRole(LemmingRole role, Position pos) {
		int i=0;
		while(i< objects.size()&&!objects.get(i).isInPosition(pos))
			i++;

		if(i!=objects.size())
			objects.get(i).setRole(role);
    }

	public boolean receiveInteractionsFrom(GameItem obj) {
		return false;
	}

}

package tp1.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.logic.gameobjects.GameObject;

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
		while(i<objects.size()){
			if(!objects.get(i).isAlive()){
				objects.remove(i);
				notifyLemmingDead();
			}else if(isInExit(objects.get(i))){
				objects.remove(i);
				notifyLemmingExit();
			} else
				i++;
		}
	}
	//TODO fill your code

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
		while (i< objects.size() && !(objects.get(i).isInPosition(pos) && objects.get(i).isSolid())) i++;
		return i!=objects.size();
	}
	private boolean isInExit(GameObject g){
		return false;
	}
}

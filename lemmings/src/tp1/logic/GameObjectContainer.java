package tp1.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.logic.gameobjects.GameObject;

public class GameObjectContainer {
	private List<GameObject> objects;

	public GameObjectContainer() {
		objects = new ArrayList<GameObject>();
	}
	
	// Only one add method (polymorphism)
	public void add(GameObject object) {
		objects.add(object);
	}

	public String someoneInPosition(Position p) {
		String str = "";
		for(GameObject object: objects) {
			if(object.isInPosition(p))
				str += object.getIcon();
		}
		return str;
	}

	public int get_nexit_lemmings() {
		return 0;
	}

	public int get_ndead_lemmings() {
		return 0;
	}

	public int get_nlemmings() {
		return 0;
	}
	//TODO fill your code

	// TODO you should write a toString method to return the string that represents the object status
	// @Override
	// public String toString()
}

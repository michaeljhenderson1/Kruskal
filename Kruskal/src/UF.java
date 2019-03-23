import java.util.*;

public class UF {
	ArrayList<HashSet<Integer>> components;
	public UF(int V) {
		components = new ArrayList<HashSet<Integer>>();
		for(int i = 0; i < V; i++) {
			components.add(new HashSet<Integer>());
			components.get(i).add(i);
		}
	}
	//Returns true if v and w are in the same HashSet
	public boolean find(int v, int w) {
		for(HashSet<Integer> set: components) {
			if(set.contains(v) && set.contains(w))
				return true;
		}
		return false;
	}
	//Combines two HashSets with the different vertices, and deletes the unnecessary set.
	public void unite(int v, int w) {
		int setV, setW;
		//Finds which sets v and w are in
		for(setV = 0; setV < components.size(); setV++) {
			if(components.get(setV).contains(v))
				break;
		}
		for(setW = 0; setW < components.size(); setW++) {
			if(components.get(setW).contains(w))
				break;
		}
		//Adds the elements from list w to list v
		for(Integer vert : components.get(setW)) {
			components.get(setV).add(vert);
		}
		//The set w is removed.
		components.remove(setW);
	}
}

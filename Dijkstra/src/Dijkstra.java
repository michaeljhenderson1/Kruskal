import java.util.*;

public class Dijkstra {
	Set<Integer> s;//Stores visited vertices (i.e. Already in the solution set for Dijkstra's Algorithm)
	Queue<Path> q;//PriorityQueue of paths being selected.
	Map<Integer,Path> solution;//Stores the paths used in the solution

	//Constructor
	//Performs Dijstra's Algorithm on the Graph with a given starting vertex
	public Dijkstra(Graph g, Integer start) {
		s = new HashSet<Integer>();
		q = new PriorityQueue<Path>();
		solution = new HashMap<Integer,Path>();
		solution.put(start,new Path(start));//Adds the starting vertex to the solution set
		s.add(start);//Initializes the set of visited vertices
		Integer cur = start;
		//Going to perform steps of Dijkstra's Algorithm until all vertices have been visited.
		do{
			//Add all of cur's neighboring paths to the PriorityQueue
			for(Edge e : g.adj(cur)) {//Visits all of cur's accessible edges
				//Filters out edges with vertices in the solution set
				if(validEdge(e)) {
					q.add(new Path(solution.get(cur), e));
				}
			}
			//Picks the Path with the least weight from the PriorityQueue:
			//Checks if the Path is usable (i.e. Has an unvisited vertex)
			//Adds the Path to the solution set
			//Adds the vertex to the list of visited vertices.
			while(true) {
				Path check = q.remove();
				if(validPath(check)) {
					cur = check.pathTo();
					solution.put(cur,check);
					s.add(cur);
					break;
				}
			}
		}while(solution.size() < g.V());
	}
	//Filters out edges with vertices in the solution set
	private boolean validEdge(Edge e) {
		return !s.contains(e.v2());
	}
	//Messy way of checking if nodes are in the solution set already.
	private boolean validPath(Path p) {
		return !s.contains(p.pathTo());
	}
	public void printPaths() {
		for(int i = 1; i <= solution.size(); i++) {
			System.out.println("Path " + i + ": " + solution.get(i));
		}
	}
}

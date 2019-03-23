import java.util.*;

public class Graph {
	private int V;//number of vertices in a graph
	private Set<Edge>[] adj;//store all edges connecting to a vertex i.
	//^ forms the adjacency list
	//Constructor
	public Graph(int V) {
		this.V = V;
		adj = new HashSet[V];
		for(int v = 0; v < V; v++)
			adj[v] = new HashSet<Edge>();
	}
	//Methods
	public void setEdge(int v, int w, int weight) {
		Edge e = new Edge(v, w, weight);
		adj[v].add(e);
		adj[w].add(e);
	}
	public void addEdge(Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);	
	}
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	//Returns a set/list of distinct edges in the graph.
	public ArrayList<Edge> edges(){
		ArrayList<Edge> edges = new ArrayList<Edge>();
		//Traverses all of the graph's edges.
		for(int v = 0; v < this.V; v++) {
			for(Edge e : this.adj[v]) {
				if(!edges.contains(e))
					edges.add(e);
			}
		}
		
		
		return edges;
	}
	public int V() {
		return this.V;
	}
}

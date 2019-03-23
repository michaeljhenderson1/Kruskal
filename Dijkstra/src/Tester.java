
public class Tester {
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.setEdge(1, 2, 4);
		g.setEdge(1, 3, 1);
		g.setEdge(2, 1, 4);
		g.setEdge(2, 3, 2);
		g.setEdge(2,4,1);
		g.setEdge(3,1,1);
		g.setEdge(3,2,2);
		g.setEdge(3,5,6);
		g.setEdge(3,6,9);
		g.setEdge(4,2,1);
		g.setEdge(4,6,2);
		g.setEdge(5,3,6);
		g.setEdge(5,6,2);
		//g.printAllEdges();
		Dijkstra d = new Dijkstra(g, 1);
		d.printPaths();
	}
}

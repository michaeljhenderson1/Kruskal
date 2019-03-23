public class Tester {

	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.setEdge(0, 1, 12);	
		g.setEdge(1, 2, 5);
		g.setEdge(2, 3, 7);
		g.setEdge(3, 4, 6);
		g.setEdge(4, 5, 2);
		g.setEdge(5, 0, 9);
		g.setEdge(0, 4, 1);
		g.setEdge(1, 3, 4);
		
		Kruskal k = new Kruskal(g);
		for(Edge e : k.mst())
			System.out.println(e);
		
	}
}

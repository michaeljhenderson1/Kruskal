import java.util.*;

public class Kruskal {
	private Set<Edge> mst;
	//Constructor
	public Kruskal(Graph G) {
		mst = new HashSet<Edge>();
		ArrayList<Edge> edges = G.edges();
		//System.out.println(edges);
		edges.sort(Edge.BY_WEIGHT);
		//System.out.println(edges);
		UF uf = new UF(G.V());
		for(Edge e : edges) {
			if(!uf.find(e.either(), e.other(e.either()))) {
				mst.add(e);
				uf.unite(e.either(), e.other(e.either()));
				if(mst.size() == G.V() - 1 )
					break;
			}
		}
	}
	
	public Iterable<Edge> mst(){
		return mst;
	}
}

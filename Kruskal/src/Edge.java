import java.util.*;

public class Edge implements Comparable<Edge>{
	private final int v; 
	private final int w;
	private final double weight;
	//Constructor
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	//Methods
	//Returns an edge's vertex
	public int either() {
		return v;
	}
	//Returns the edge's other vertex.
	public int other(int vertex) {
		if(v == vertex)
			return w;
		else if( w == vertex)
			return v;
		else {
			System.out.println("Error in other, invalid vertex");
			return -1;
		}
	}
	public double weight(){
		return this.weight;
	}
	public final static Comparator<Edge> BY_WEIGHT = new ByWeightComparator();
	private static class ByWeightComparator implements Comparator<Edge>{
		@Override
		public int compare(Edge e, Edge f) {
			if(e.weight < f.weight) return -1;
			if(e.weight > f.weight) return 1;
			return 0;
		}
	}
	public int compareTo(Edge that) {
		if(this.weight < that.weight) return -1;
		else if( this.weight > that.weight) return 1;
		else return 0;
	}
	@Override
	public String toString() {
		String result = "(" + v + ", " + w + ")";
		return result;
	}
	
}

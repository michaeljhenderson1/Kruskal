import java.util.*;

public class Path implements Comparable<Path>{
	private int distance;
	private List<Integer> verts;
	private Integer v;
	//Constructor for Initial Path
	public Path(Integer vert) {
		distance = 0;
		verts = new ArrayList<Integer>();
		verts.add(vert);
	}
	//Constructor based on previous path, and edge connecting the two
	public Path(Path prev, Edge cur) {
		distance = prev.distance() + cur.weight();
		this.verts = new ArrayList<Integer>();
		for(Integer vert : prev.verts) {
			this.verts.add(vert);
		}
		this.verts.add(cur.v2());
		v = cur.v2();
	}
	@Override
	public String toString() {
		if(verts == null || verts.isEmpty())
			return "";
		Integer first = this.verts.get(0);
		Integer last = this.verts.get(verts.size()-1);
		String result = "vertex " + first + " to vertex " + last + ", ";
		for(int i = 0; i < verts.size(); i++) {
			result += verts.get(i);
			if(i < verts.size() - 1)
				result += "-->";
		}
		result += ", length " + distance;
		return result;
	}
	public int distance() { return this.distance; }
	
	public final static Comparator<Path> BY_DISTANCE = new ByDistanceComparator();
	private static class ByDistanceComparator implements Comparator<Path>{
		@Override
		public int compare(Path e, Path f) {
			if(e.distance < f.distance) return -1;
			if(e.distance > f.distance) return 1;
			return 0;
		}
	}
	public int compareTo(Path that) {
		if(this.distance < that.distance) return -1;
		else if( this.distance > that.distance) return 1;
		else return 0;
	}
	//Acquires the vertices of the previous edge
	public Integer pathTo() {
		return v;
	}
}

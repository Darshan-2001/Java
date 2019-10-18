
public class Vertex implements Comparable<Vertex> {
	public double dist = Double.MAX_VALUE;
	public Vertex prev = null;
	public int x = 0;
	public int y = 0;

	public Vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Vertex v) {
		if(dist < v.dist)
			return -1;
		else if(dist > v.dist)
			return 1;
		else
			return 0;
	}
	
	public String toString() {
		return x+" "+" "+dist;
	}
	
	public static double distance(Vertex v1, Vertex v2) {
		return Math.sqrt(Math.pow(v1.x-v2.x, 2)+Math.pow(v1.y-v2.y, 2));
	}
	

}

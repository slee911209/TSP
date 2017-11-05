
public class Edge {

	private City[] edge;

	public Edge() {
		edge = new City[2];
	}
	
	public Edge(City c, City c1) {
		edge = new City[2];
		edge[0] = c;
		edge[1] = c1;
	}

	public void setCities(City c, City c1) {
		edge[0] = c;
		edge[1] = c1;
	}

	public double getDist() {
		return edge[0].distanceToCity(edge[1]);
	}
	
	public City[] getCities() {
		return edge;
	}
	
	// only used for symmteric
	public boolean sameEdge(Edge e) {
		if (e.edge[0] == edge[1] && e.edge[1] == edge[0]) {
			return true;
		}
		return false;
	}
	
	public boolean contains(City c) {
		if(edge[0] == c || edge[1] == c) {
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if(this.edge[0] == ((Edge)o).edge[0] && this.edge[1] == ((Edge)o).edge[1]) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "(" + edge[0] + ", " + edge[1] + ") :" + getDist();
	}

}

import java.util.ArrayList;

/*
 *1. Sort all edges. 
 *2. Select the shortest edge and add it to our tour if it doesn’t violate any of the above constraints. 
 *3. Do we have N edges in our tour? If no, repeat step 2.
*/

public class Greedy {
	private Tour tour;
	private ArrayList<Edge> edges;
	
	public Greedy() {
		this.tour = new Tour();
		this.edges = new ArrayList<>();
	}
	
	public Tour getTour() {
		return this.tour;
	}
	
	public Tour getRoute() {
		return tour;
	}
	
	public double getTotalDist() {
		return tour.getDist();
	}
	
	public Tour getShortestRoute(Graph graph) {
		while(edges.size() != graph.getNOfCities()) {
			for(Edge e : graph.getEdges()) {
				if(checkConstraints()) {
					edges.add(e);
				}
			}
			break;
		}
		//create tour from edges
		return tour;
	}
	
	public boolean checkConstraints() {
		return true;
	}
}

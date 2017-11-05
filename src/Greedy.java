import java.util.ArrayList;

/*
 *1. Sort all edges. 
 *2. Select the shortest edge and add it to our tour if it doesn’t violate any of the above constraints. 
 *3. Do we have N edges in our tour? If no, repeat step 2.
*/

public class Greedy {

	private Tour tour;
	private Tour subtour;
	private Graph graph;
	private Graph subgraph;

	public Greedy(Graph graph) {
		this.graph = graph;
		this.tour = new Tour();
		this.subtour = new Tour();
		this.subgraph = new Graph();
		for (City c : graph.getCities()) {
			subgraph.addCity(c);
		}
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

	public Tour getShortestRoute() {
		for (Edge e : graph.getEdges()) {
			if (checkConstraints(e)) {
				subgraph.addEdge(e);
			}
			if (subgraph.getEdges().size() == (graph.getNOfCities() - 1)) {
				break;
			}
		}
/*
		for (Edge e : subgraph.getEdges()) {
			System.out.println(":" + e);
		}
*/
		addLastEdge();
		createTour();
		return tour;
	}

	public boolean checkConstraints(Edge e) {
		// does not create subtour
		// each vertex has 2 edges
		subgraph.addEdge(e);
		for (City c : subgraph.getCities()) {
			if (getNOfEdges(c) > 2) {
				subgraph.removeEdge(e);
				return false;
			}
		}
		if (createSubtour()) {
			subgraph.removeEdge(e);
			return false;
		}
		subgraph.removeEdge(e);
		return true;
	}

	public boolean createSubtour() {

		if (subgraph.getEdges().size() == 0) {
			return false;
		}

		subtour = new Tour();
		boolean added = false;
		ArrayList<Tour> subtours = new ArrayList<>();
		ArrayList<Edge> edges = new ArrayList<>();

		for (Edge e : subgraph.getEdges()) {
			edges.add(e);
		}

		subtour.add(subgraph.getEdges().get(0).getCities()[0]);
		subtour.add(subgraph.getEdges().get(0).getCities()[1]);
		edges.remove(subgraph.getEdges().get(0));

		while (!edges.isEmpty()) {
			added = false;
			for (Edge e : subgraph.getEdges()) {
				if (subtour.getList().getLast().equals(e.getCities()[0])) {
					if (edges.contains(e)) {
						subtour.add(e.getCities()[1]);
						edges.remove(e);
						added = true;
					}
				}
				if (subtour.getList().getLast().equals(e.getCities()[1])) {
					if (edges.contains(e)) {
						subtour.add(e.getCities()[0]);
						edges.remove(e);
						added = true;
					}
				}
			}
			if (!added) {
				subtours.add(subtour);
				if (!edges.isEmpty()) {
					subtour = new Tour();
					subtour.add(edges.get(0).getCities()[1]);
					subtour.add(edges.get(0).getCities()[0]);
					edges.remove(0);
				}
			}
		}
		if (subtours.isEmpty() || subtour.getList().size() == 2) {
			subtours.add(subtour);
		}
		if(subtour.getList().getFirst().equals(subtour.getList().getLast())) {
			return true;
		}
		for (Tour t : subtours) {
			if (t.getList().getFirst().equals(t.getList().getLast())) {
				return true;
			}
		}
		
		return false;
	}

	public void createTour() {

		//System.out.println("Creating Tour");
		ArrayList<Edge> edges = new ArrayList<>();

		for (Edge e : subgraph.getEdges()) {
			edges.add(e);
		}

		tour.add(subgraph.getEdges().get(0).getCities()[0]);
		tour.add(subgraph.getEdges().get(0).getCities()[1]);
		edges.remove(subgraph.getEdges().get(0));

		while (!edges.isEmpty()) {
			for (Edge e : subgraph.getEdges()) {
				if (tour.getList().getLast().equals(e.getCities()[0])) {
					if (edges.contains(e)) {
						tour.add(e.getCities()[1]);
						edges.remove(e);
					}
				}
				if (tour.getList().getLast().equals(e.getCities()[1])) {
					if (edges.contains(e)) {
						tour.add(e.getCities()[0]);
						edges.remove(e);
					}
				}
			}
		}
		tour.completeTour();
	}

	public void addLastEdge() {
		City[] lastEdge = new City[2];
		int i = 0;
		for (City c : subgraph.getCities()) {
			if (getNOfEdges(c) != 2) {
				lastEdge[i] = c;
				if (i == 1) {
					break;
				}
				i++;
			}
		}
		Edge e = new Edge(lastEdge[0], lastEdge[1]);
		//System.out.println(e);
		if (!subgraph.getEdges().contains(e)) {
			subgraph.addEdge(e);
		}
	}

	public int getNOfEdges(City c) {
		int counter = 0;
		for (Edge e : subgraph.getEdges()) {
			if (e.contains(c)) {
				counter++;
			}
		}
		return counter;
	}
}

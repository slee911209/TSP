import java.util.ArrayList;

/*
 *1. Select the shortest edge, and make a subtour of it.
 *2. Select a city not in the subtour, having the shortest distance to any one of the cities in the subtoor.
 *3. Find an edge in the subtour such that the cost of inserting the selected city between the edge’s cities will be minimal.
 *4. Repeat step 2 until no more cities remain.
*/
public class VertexInsertion {
	
	private Tour tour;
	private Graph graph;
	private Graph subgraph;
	
	public VertexInsertion(Graph graph) {
		this.graph = graph;
		this.subgraph = new Graph();
		this.tour = new Tour();
	}
	
	public Tour getTour() {
		return this.tour;
	}
	
	public Tour getRoute() {
		return tour;
	}
	
	public Graph getGraph() {
		return this.graph;
	}
	
	public double getTotalDist() {
		return tour.getDist();
	}
	
	public Tour getShortestRouteVI() {
		//start with shortest edge
		City nextCity;
		Edge e = graph.getEdges().get(0);
		for(City c : e.getCities()) {
			subgraph.addCity(c);
		}
		subgraph.addEdge(e);
		while(subgraph.getNOfCities() != graph.getNOfCities()) {
			nextCity = chooseNextCity();
			insertCity(nextCity);
		}
		addLastEdge();
		createTour();
		return tour;
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
	
	public City chooseNextCity() {
		City retCity = new City();
		double minDist = 999;
		for(City c : subgraph.getCities()) {
			for(City c1 : graph.getCities()) {
				if(c.distanceToCity(c1) < minDist && !subgraph.getCities().contains(c1) && !c.equals(c1)) {
					minDist = c.distanceToCity(c1);
					retCity = c1;
				}
			}
		}
		return retCity;
	}
	
	public void insertCity(City city) {
		double minIncrease = 999;
		double increase;
		Edge e = new Edge();
		for(Edge edge : subgraph.getEdges()) {
			increase = edge.getCities()[0].distanceToCity(city) + edge.getCities()[1].distanceToCity(city) - edge.getDist();
			if(increase < minIncrease) {
				minIncrease = increase;
				e = edge;
			}
		}
		subgraph.removeEdge(e);
		subgraph.addCity(city);
		subgraph.addEdge(new Edge(e.getCities()[0], city));
		subgraph.addEdge(new Edge(e.getCities()[1], city));
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

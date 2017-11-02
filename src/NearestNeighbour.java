
public class NearestNeighbour {
	
	private Tour tour;
	
	public NearestNeighbour() {
		this.tour = new Tour();
	}
	
	public double getTotalDist() {
		return getTour().getDist();
	}
	
	public Tour getTour() {
		return this.tour;
	}
	
	public void resetTour() {
		this.tour = new Tour();
	}
	
	public Tour getShortestRouteNN(Graph graph, City startingCity) {
		City currCity = startingCity;
		City nextCity = null;
		resetTour();
		while(!graph.fullyVisited()) {
			double shortestDist = 999;
			for(City c : graph.getCities()) {
				if(!c.visited()) {
					if(!currCity.equals(c) && currCity.distanceToCity(c)<shortestDist) {
						shortestDist = currCity.distanceToCity(c);
						nextCity = c;
					}
				}
			}
			currCity.markAsVisited(true);
			tour.add(currCity);
			currCity = nextCity;
		}
		graph.resetVisits();
		tour.completeTour();
		return tour;
	}
	
}

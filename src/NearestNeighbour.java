
public class NearestNeighbour {
	
	protected double totalDist;
	
	public NearestNeighbour() {
		this.totalDist = 0;
	}
	
	public double getTotalDist() {
		return this.totalDist;
	}
	
	public void addToTotalDist(double dist) {
		this.totalDist += dist;
	}
	
	public String getShortestRouteNN(Graph graph, City startingCity) {
		City currCity = startingCity;
		City nextCity = null;
		String route = "";
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
			route += currCity.getName() + " ";
			if(shortestDist != 999) {
				addToTotalDist(shortestDist);
			}
			currCity = nextCity;
		}
		graph.resetVisits();
		return route;
	}
	
}

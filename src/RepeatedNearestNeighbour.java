import java.util.HashMap;
import java.util.Map.Entry;

public class RepeatedNearestNeighbour extends NearestNeighbour {
	
	private HashMap<String, Double> routes;
	private String shortestRoute;
	private double shortestTotalDist;
	
	public RepeatedNearestNeighbour() {
		routes = new HashMap<>();
		shortestRoute = "";
		shortestTotalDist = 999;
	}
	
	public String getShortestRoute() {
		return this.shortestRoute;
	}
	
	public void setShortestRoute(String route) {
		shortestRoute = route;
	}
	
	public double getShortestTotalDist() {
		return this.shortestTotalDist;
	}
	
	public void setShortestTotalDist(double dist) {
		shortestTotalDist = dist;
	}
	
	public void resetTotalDistance() {
		this.totalDist = 0;
	}
	
	public String getShortestRouteRNN(Graph graph) {
		for(City city : graph.getCities()) {
			String route = getShortestRouteNN(graph, city);
			double dist = getTotalDist();
			routes.put(route, dist);
			resetTotalDistance();
		}
		for(Entry<String, Double> entry : routes.entrySet()) {
			if(entry.getValue() < getShortestTotalDist()) {
				setShortestTotalDist(entry.getValue());
				setShortestRoute(entry.getKey());
			}
		}
		return getShortestRoute();
	}
}

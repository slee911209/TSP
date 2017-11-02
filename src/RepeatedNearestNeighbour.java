import java.util.HashMap;
import java.util.Map.Entry;

public class RepeatedNearestNeighbour extends NearestNeighbour {
	
	private HashMap<Tour, Double> routes;
	private Tour route;
	
	public RepeatedNearestNeighbour() {
		routes = new HashMap<>();
		route = new Tour();
	}
	
	public double getShortestTotalDist() {
		return this.route.getDist();
	}
	
	public Tour getShortestRouteRNN(Graph graph) {
		route = new Tour();
		double shortestTotalDist = 999;
		for(City city : graph.getCities()) {
			route = getShortestRouteNN(graph, city);
			double dist = route.getDist();
			routes.put(route, dist);
		}
		for(Entry<Tour, Double> entry : routes.entrySet()) {
			if(entry.getValue() < shortestTotalDist) {
				shortestTotalDist = entry.getValue();
				route = entry.getKey(); 
			}
		}
		route.completeTour();
		return route;
	}
}

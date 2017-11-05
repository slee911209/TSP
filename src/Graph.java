import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Graph {

	protected ArrayList<City> cities;
	protected ArrayList<Edge> edges;
	
	public Graph() {
		cities = new ArrayList<>();
		edges = new ArrayList<>();
	}
	
	public Graph(int nOfCities) {
		cities = new ArrayList<>();
		edges = new ArrayList<>();
		createRandomCities(nOfCities);
		fillEdges();
		sortEdges();
	}
	
	public int getNOfCities() {
		return cities.size();
	}
	
	public ArrayList<City> getCities() {
		return this.cities;
	}
	
	public ArrayList<Edge> getEdges() {
		return this.edges;
	}
	
	public void addCity(City city) {
		if(!cities.contains(city)) {
			cities.add(city);
		}
	}
	public void createRandomCities(int nOfCities) {
		for(int i = 0; i < nOfCities; i++) {
			cities.add(new City("c" + i, (int) (Math.random()*100 + 1), (int) (Math.random()*100 + 1)));
		}
	}
	
	public void fillEdges() {
		Edge edge;
		for(City c : cities) {
			for(City c1 : cities) {
				if(!c.equals(c1)) {
					edge = new Edge(c, c1);
					addEdge(edge);
				}
			}
		}
	}
	
	public boolean addEdge(Edge edge) {
		for(Edge e : this.edges) {
			if(e.sameEdge(edge)) {
				return false;
			}
		}
		this.edges.add(edge);
		return true;
	}
	
	public void removeEdge(Edge edge) {
		this.edges.remove(edge);
	}
	
	public void sortEdges() {
		Collections.sort(edges, new Comparator<Edge>() {
		    @Override
		    public int compare(Edge e1, Edge e2) {
		        return Double.compare(e1.getDist(), e2.getDist());
		    }
		});
	}
	
	public boolean fullyVisited() {
		for(City c : getCities()) {
			if(!c.visited()) {
				return false;
			}
		}
		return true;
	}
	
	public void resetVisits() {
		for(City c : getCities()) {
			c.markAsVisited(false);
		}
	}
	
	public String toString() {
		String ret = "";
		for(City c : getCities()) {
			ret += c + "\n";
		}
		return ret;
	}
	
}

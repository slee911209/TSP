
public class Graph {

	private int nOfCities;
	private City[] cities;
	
	public Graph(int nOfCities) {
		this.nOfCities = nOfCities;
		cities = new City[nOfCities];
		createRandomCities();
	}
	
	public int getNOfCities() {
		return this.nOfCities;
	}
	
	public City[] getCities() {
		return this.cities;
	}
	
	public void createRandomCities() {
		for(int i = 0; i < getNOfCities(); i++) {
			cities[i] = new City("c" + i, (int) (Math.random()*100 + 1), (int) (Math.random()*100 + 1));
		}
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

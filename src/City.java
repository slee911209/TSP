
public class City {
	
	private int x;
	private int y;
	private String name;
	private boolean visited;
	
	public City(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.visited = false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean visited() {
		return this.visited;
	}
	
	public void markAsVisited(boolean visited) {
		this.visited = visited;
	}
	
	public double distanceToCity(City city) {
		double dist = 0;
		// euclidean distance between cities
		double xDist = Math.pow((getX() - city.getX()), 2);
		double yDist = Math.pow((getY() - city.getY()), 2);
		dist = Math.sqrt(xDist + yDist);
		return dist;
	}
	
	//if name is the same, it is the same city as city name should be unique
	public boolean equals(City city) {
		if(this.getName().equals(city.getName())) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return getName() + ": (" + getX() + ", " + getY() + ")"; 
	}
}

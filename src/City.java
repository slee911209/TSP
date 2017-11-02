
public class City {
	
	private int x;
	private int y;
	private String name;
	private boolean visited;
	
	public City() {
	}
	
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
	
	@Override
	//if name is the same, it is the same city as city name should be unique
	public boolean equals(Object obj) {
		if(this.getName().equals(((City)obj).getName())) {
			return true;
		}
		return false;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * public boolean equals(Object obj) {
23
	        return (this.firstName.equals(((User) obj).firstName)
24
	                && this.lastName.equals(((User) obj).lastName) && this.email
25
	                    .equals(((User) obj).email));
26
	    }
	 */
	
	public String toString() {
		return getName() + ": (" + getX() + ", " + getY() + ")"; 
	}
}

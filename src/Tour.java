import java.util.LinkedList;

import javafx.scene.Node;

public class Tour {
	private LinkedList<City> tour;
	
	public Tour() {
		this.tour = new LinkedList<>(); 
	}
	
	public void add(City city) {
		tour.add(city);
	}
	
	public LinkedList<City> getList() {
		return this.tour;
	}
	
	public double getDist(){
		double dist = 0;
		
		for(int i = 0; i < tour.size(); i++) {
			if(i!=0) {
				dist += tour.get(i-1).distanceToCity(tour.get(i));
			}
		}
		return dist;
	}
	
	public void completeTour() {
		if(!tour.getLast().equals(tour.getFirst())) {
			tour.add(tour.getFirst());
		}
	}
	
	public boolean contains(City c) {
		for(City c1 : this.tour) {
			if(c.equals(c1)) {
				return true;
			}
		}
		return false;
	}
	
	
	public String toString() {
		String retString = "";
		for(City c : getList()) {
			retString+= c.getName() + " ";
		}
		return retString;
	}
}

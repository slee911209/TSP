
public class Main {

	public static void main(String[] args) {
		int nOfCities = 10;
		Graph graph = new Graph(nOfCities);
		
		/*
		Graph graph = new Graph();
		City c0 = new City("c0", 65, 15);
		City c1 = new City("c1", 21, 91);
		City c2 = new City("c2", 87, 95);
		City c3 = new City("c3", 52, 72);
		City c4 = new City("c4", 25, 1);
		graph.addCity(c0);
		graph.addCity(c1);
		graph.addCity(c2);
		graph.addCity(c3);
		graph.addCity(c4);
		graph.fillEdges();
		graph.sortEdges();
		*/
		
		NearestNeighbour nn = new NearestNeighbour();
		RepeatedNearestNeighbour rnn = new RepeatedNearestNeighbour();
		Greedy g = new Greedy(graph);
		VertexInsertion vi = new VertexInsertion(graph);
		
		System.out.println(graph);
		
		System.out.println("NN: " + nn.getShortestRouteNN(graph, graph.getCities().get(0)));
		System.out.println("NN: " + nn.getTotalDist());
		System.out.println("RNN: " + rnn.getShortestRouteRNN(graph));
		System.out.println("RNN: " + rnn.getShortestTotalDist());
		System.out.println("VI: " + vi.getShortestRouteVI());
		System.out.println("VI: " + vi.getTotalDist());
		System.out.println("G: " + g.getShortestRoute());
		System.out.println("G: " + g.getTotalDist());
	}
}

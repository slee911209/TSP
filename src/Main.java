
public class Main {

	public static void main(String[] args) {
		int nOfCities = 10;
		Graph graph = new Graph(nOfCities);
		NearestNeighbour nn = new NearestNeighbour();
		RepeatedNearestNeighbour rnn = new RepeatedNearestNeighbour();
		Greedy g = new Greedy();
		VertexInsertion vi = new VertexInsertion(graph);
		
		System.out.println(graph);
		
		System.out.println("NN: " + nn.getShortestRouteNN(graph, graph.getCities().get(0)));
		System.out.println("NN: " + nn.getTotalDist());
		System.out.println("RNN: " + rnn.getShortestRouteRNN(graph));
		System.out.println("RNN: " + rnn.getShortestTotalDist());
		System.out.println("VI: " + vi.getShortestRouteVI());
		System.out.println("VI: " + vi.getTotalDist());
		System.out.println("G: " + g.getShortestRoute(graph));
		System.out.println("G: " + g.getTotalDist());
	}
}

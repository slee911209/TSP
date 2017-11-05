
public class Main {

	public static void main(String[] args) {
		int nOfCities = 150;
		Graph graph = new Graph(nOfCities);
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

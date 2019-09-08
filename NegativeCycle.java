import java.util.Arrays;
import java.util.Scanner;

public class NegativeCycle {
	public static String detect_negative_cycle(int[][] graph, int vertices,
			int edges) {
		int[] dist = new int[vertices + 1];
		for (int v = 1; v < vertices + 1; v++) {
			dist[v] = 10000000;
		}
		int start = graph[0][0];
		dist[start] = 0;
		for (int i = 0; i < vertices - 1; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (dist[graph[j][1]] > dist[graph[j][0]] + graph[j][2]) {
					dist[graph[j][1]] = dist[graph[j][0]] + graph[j][2];
				}
			}
		}

		for (int j = 0; j < graph.length; j++) {
			if (dist[graph[j][1]] > dist[graph[j][0]] + graph[j][2]) {
				return "YES";
			}
		}
		return "NO";

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// number of vertices
		int vertices = sc.nextInt();
		// number of edges
		int edges = sc.nextInt();
		int[] end_index = new int[vertices + 1];
		int[][] graph = new int[edges][3];
		// loop that takes the input for the graph
		for (int i = 0; i < edges; i++) {
			// first node to take input
			int first_vertex = sc.nextInt();
			// the neighbour of the node
			int second_vertex = sc.nextInt();
			// weight of the edge
			int weight_in = sc.nextInt();
			graph[i][0] = first_vertex;
			// add in the graph with neighbours
			graph[i][1] = second_vertex;
			// maintain the weight of the edge
			graph[i][2] = weight_in;

		}
		// System.out.println(Arrays.deepToString(graph));
		String ans = detect_negative_cycle(graph, vertices, edges);
		System.out.println(ans);
		sc.close();
	}
}
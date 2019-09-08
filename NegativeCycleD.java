/***
 *class that finds negative edge cycle in the given graph
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

public class NegativeCycleD {
	//to maintain in the count of the vertices to be added in the stack
	static int count = 1;
	/**
	 * Method to update the distance array
	 */
	public static void update(int current_node, int[][] graph_with_edges,
			int[][] graph_with_corresponding_weight,
			int[] end_index_with_edges, int[] queue, int[] dist,
			boolean[] visited) {
		//loop to find the nodes connected to find the shortest path to reach destination
		for (int i = 0; i < end_index_with_edges[current_node]; i++) {
			//if the nodes current distance is greater than the distance of the other node update the minimum cost
			if (dist[graph_with_edges[current_node][i]] > dist[current_node]
					+ graph_with_corresponding_weight[current_node][i]) {
				
				//update the dist array
				dist[graph_with_edges[current_node][i]] = dist[current_node]
						+ graph_with_corresponding_weight[current_node][i];
				//if the visited graph false add in queue then make it true and update
				if (visited[graph_with_edges[current_node][i]] == false) {
					queue[count] = graph_with_edges[current_node][i];
					visited[graph_with_edges[current_node][i]] = true;
					count = count + 1;
				}
			}

		}
	}
/**
 * Method that detects a negative cycle
 * @param graph								the original graph structure with vertices and edges
 * @param vertices							the number of vertices in the graph
 * @param edges								the number of edges in the graph
 * @param start								the start node to perform djikstra
 * @param graph_with_edges					
 * @param end_index_with_edges				the array that maintans count of the neighbors of the nodes
 * @param graph_with_corresponding_weight	the weights of the graph according to the edges
 * @param visited							the visited array that maintains nodes are visited or not
 */
	public static void detect_negative_cycle(int[][] graph, int vertices,
			int edges, int start, int[][] graph_with_edges,
			int[] end_index_with_edges,
			int[][] graph_with_corresponding_weight, boolean[] visited) {
		//distance array that maintains the distance
		int[] dist = new int[vertices + 1];
		//queue that maintains the structure of the shortest path
		int[] queue = new int[vertices + 1];
		//make all the vertices to infinite value
		for (int v = 1; v < vertices + 1; v++) {
			dist[v] = 10000000;
		}
		//assign the start node distance to zero
		dist[start] = 0;
		//update the start node putting it's values in the queue
		update(start, graph_with_edges, graph_with_corresponding_weight,
				end_index_with_edges, queue, dist, visited);
		dist[start] = 1000000000;
		//System.out.println(Arrays.toString(queue));
		//System.out.println(Arrays.toString(visited));
		//System.out.println(Arrays.toString(dist));
		//loop to find the shortest path and neighbours performing BFS and 
		//simultaneously updating distance to minimum to reach that node
		for (int i = 1; i <= vertices; i++) {
			//updating the queue
			int small_dist = dist[queue[i]];
			int index=i;
			for(int j = i; j <= vertices; j++) {

				if(small_dist > dist[queue[j]]) {

					small_dist = dist[queue[j]];

					index = j;

				}

			}

			update(queue[index], graph_with_edges, graph_with_corresponding_weight,

					end_index_with_edges, queue, dist, visited);

			queue[index] = queue[i];

		}

		// System.out.println(Arrays.toString(queue));
		// System.out.println(Arrays.toString(visited));
		// System.out.println(Arrays.toString(dist));
		//if the distance of the current node is less than zero then update to YES it contains negative cycle
		if (dist[start] < 0) {
			System.out.println("YES");
		} else {
			//print no
			System.out.println("NO");
		}
	}

/**
 * Main method the driver program
 * @param args
 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//the start of the edge of negative cycle
		int destination = 0;
		// number of vertices
		int vertices = sc.nextInt();
		// number of edges
		int edges = sc.nextInt();
		// int[] end_index = new int[vertices + 1];
		boolean visited[] = new boolean[vertices + 1];
		//loop for the number of vertices
		for (int i = 1; i <= vertices; i++) {
			//mark it false
			visited[i] = false;
		}
		//maintain the edges of the node
		int[] end_index_with_edges = new int[vertices + 1];
		int[][] graph = new int[edges][3];
		//graph of the edges structure
		int[][] graph_with_edges = new int[vertices + 1][vertices + 1];
		//graph with corresponding weights
		int[][] graph_with_corresponding_weight = new int[vertices + 1][vertices + 1];
		// loop that takes the input for the graph
		for (int i = 0; i < edges; i++) {
			// first node to take input
			int first_vertex = sc.nextInt();

			// the neighbour of the node
			int second_vertex = sc.nextInt();
			// weight of the edge
			int weight_in = sc.nextInt();
			//if weight of edge negative maintain the start and end of the edge
			if (weight_in < 0) {
				
				destination = first_vertex;
			}
			graph_with_edges[first_vertex][end_index_with_edges[first_vertex]] = second_vertex;
			graph_with_corresponding_weight[first_vertex][end_index_with_edges[first_vertex]] = weight_in;
			end_index_with_edges[first_vertex]++;
			graph[i][0] = first_vertex;
			// add in the graph with neighbours
			graph[i][1] = second_vertex;
			// maintain the weight of the edge
			graph[i][2] = weight_in;

		}
		//System.out.println(Arrays.deepToString(graph));
		//System.out.println(Arrays.deepToString(graph_with_edges));
		//System.out.println(Arrays.deepToString(graph_with_corresponding_weight));
		//System.out.println(start);
		//System.out.println(destination);
		//method to find the negative cycle
		detect_negative_cycle(graph, vertices, edges, destination,
				graph_with_edges, end_index_with_edges,
				graph_with_corresponding_weight, visited);

		// String ans = detect_negative_cycle(graph, vertices, edges);
		// System.out.println(ans);
		//Scanner class close
		sc.close();
	}

}

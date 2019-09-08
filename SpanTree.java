/***
 *class that finds the number of shortest path to reach the destination from source
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

/***
 *class that finds the cost of a minimum-cost F-containing spanning tree, or -1 if no such spanning tree exists.
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */
public class SpanTree {
	//variable that maintains minimum cost
	static int min_cost = 0;
	//variable that have vertices included in the graph count
	static int vertices_include_in_graph = 0;
/**
 * 
 * @param current_node	Checking if the current node added it forms cycle
 * @param parent_node	-1
 * @param visited		boolean visited array
 * @param end_index		end index array 
 * @param graph			graph structure that contains the structure of minimum span tree
 * @return				if it has cycle or not boolean values
 */
	public static boolean DFS(int current_node,int parent_node,boolean visited[],int[] end_index,int[][] graph) {
		//mark the current node true
		visited[current_node] = true;
		//LOOP till the end index of current node find cycle going through its neighbours
		for(int i = 0; i < end_index[current_node]; i++) {
			//its neighbour stored in the next index variable
			int next_index = graph[current_node][i];
			//if visited is false
			if(visited[next_index] == false) {
				//recursive call to dfs function
				DFS(next_index, current_node, visited, end_index, graph);
				//if visited found true that means it contains cycle and below code executed
			} else {

				//Detected Cycle

				if(next_index != parent_node) return true;

			}

		}
		//If no cycle return false
		return false;

	}
/**
 * Merging while sorting the weights
 * @param graph_not_included the graph structure including the edges weight
 * @param lowpoint			start point
 * @param midpoint			midpoint of the array
 * @param highpoint			end point
 */


	public static void merge(int[][] graph_not_included, int lowpoint, int midpoint, int highpoint) {
		//initializng the arrays size
		int first_subarray = midpoint - lowpoint, second_subarray = highpoint - midpoint + 1;
		//left subarray
		int left[][] = new int[first_subarray][4];
		//right subarray
		int right[][] = new int[second_subarray][4];
		//initializing i,j,k
		int k = lowpoint, i = 0, j = 0;
		//loop for left array
		for (int m = 0; m < first_subarray; m++) {

			left[m] = Arrays.copyOf(graph_not_included[lowpoint + m], 4);

		}
		//loop for right array
		for (int n = 0; n < second_subarray; n++) {

			right[n] = Arrays.copyOf(graph_not_included[midpoint + n], 4);

		}
		//loop for checking the elemens in left and right and include in the original array
		while (i < first_subarray && j < second_subarray) {
			if (left[i][2] <= right[j][2]) {
				graph_not_included[k] =  Arrays.copyOf(left[i],4);

				i++;

			} else {

				graph_not_included[k] =  Arrays.copyOf(right[j],4);

				j++;

			}

			k++;

		}
		//conditions and loop for remaining elements in the both array

		if (i < first_subarray) {

			while (i < first_subarray) {

				graph_not_included[k] = Arrays.copyOf(left[i],4);

				i++;

				k++;

			}

		} else {

			while (j < second_subarray) {

				graph_not_included[k] = Arrays.copyOf(right[j],4);

				j++;

				k++;

			}

		}

	}
/**
 * Merge sort applied to the vertices not in subset F
 * @param graph_not_included	graph structure
 * @param lowpoint				start point
 * @param highpoint				end point
 */


	public static void sort(int[][] graph_not_included, int lowpoint, int highpoint) {
		//base condition
		if (lowpoint < highpoint) {
			//finding the midpoint
			int midpoint = (lowpoint + highpoint + 1) / 2;
			//sort function recursive call
			sort(graph_not_included, lowpoint, midpoint - 1);
			//sort function recursive call
			sort(graph_not_included, midpoint, highpoint);
			//merging the sorted array
			merge(graph_not_included, lowpoint, midpoint, highpoint);

		}

	}
/**
 * 
 * @param vertices	total number of vertices in the graph
 * @param edges		total edges in the graph
 * @param graph		graph structure included F subset
 * @param end_index	array that maintains count of neighbours
 * @param graph_not_included	graph structure that is not included in the F subset
 * @return			the minimum cost for the spanning tree
 */
	public static int min_cost_cal(int vertices, int edges, int[][] graph, int[] end_index, int[][] graph_not_included) {
		//sorting the graph not included according to weights using merge sort
		sort(graph_not_included, 0, graph_not_included.length - 1);
		//boolean array to maintain node visited or not
		boolean visited[] = new boolean[vertices+1];
		//loop to go through the vertices 
		for(int i = 1; i <= vertices; i++) {
			//check if it is visited is false and perform dfs to find if it has cycle
			if(visited[i] == false && DFS(i, -1, visited, end_index, graph)) return -1;
		}
		//the loop runs through the vertices not included checks if it has cycle or not if does not
		//have cycle it includes in the minimum span tree increasing cost and edges
		for(int i = vertices_include_in_graph; i < edges; i++) {
			//assign to first vertex point
			int first_vertex = graph_not_included[i][0];
			//neighbour that forms edge is included in the second vertex
			int second_vertex = graph_not_included[i][1];
			//graph structure included in the structure
			graph[first_vertex][end_index[first_vertex]] = second_vertex;
			graph[second_vertex][end_index[second_vertex]] = first_vertex;
			//end index array updated
			end_index[first_vertex]++;
			end_index[second_vertex]++;
			//visited array initialized
			visited = new boolean[vertices+1];
			//DFS is checked for the vertices if it returns true
			if(DFS(first_vertex, -1, visited, end_index, graph)) {
				//decrease from the end index list 
				end_index[first_vertex]--;
				end_index[second_vertex]--;

			} else {
				//update the minimum cost
				min_cost += graph_not_included[i][2];
				//update the number of vertices included in the span tree i.e., the edges
				vertices_include_in_graph += 1;

			}

		}



		// IF all vertices are included

		if(vertices_include_in_graph == vertices - 1) {
			//return the minimum cost
			return min_cost;

		}
		//return -1 if cycle detected
		return -1;

	}
/**
 * Main Method that runs the program
 * @param args
 */
	public static void main(String[] args) {
		//Scanner class that takes the input
		Scanner sc = new Scanner(System.in);
		//Number of vertices in the graph
		int vertices = sc.nextInt();
		//Number of edges in the graph
		int edges = sc.nextInt();
		//graph structure for those not in the subset
		int[][] graph_not_included = new int[edges][4];
		//graph structure used to find the minimum spanning tree
		int[][] graph = new int[vertices+1][vertices+1];
		//end index array that maintains the array of number of neighbours each node
		int[] end_index = new int[vertices + 1];
		//loop that takes input
		for (int i = 0; i < edges; i++) {
			//first node to take input
			int first_vertex = sc.nextInt();
			//the neighbour of the node
			int second_vertex = sc.nextInt();
			//weight of the edge
			int weight_in = sc.nextInt();
			//if included in subset / not
			int include_F = sc.nextInt();
			//if included
			if (include_F == 1) {
				//add in the graph with neighbours
				graph[first_vertex][end_index[first_vertex]] = second_vertex;
				//add in the graph with neighbours
				graph[second_vertex][end_index[second_vertex]] = first_vertex;
				//increase end index of first vertex
				end_index[first_vertex]++;
				//increase end index of second index
				end_index[second_vertex]++;
				//increase the minimum cost
				min_cost += weight_in;
				//increase the vertices in the graph
				vertices_include_in_graph++;

			} else {
				//added to graph not included structure
				//add in the graph with neighbours
				graph_not_included[i][0] = first_vertex;
				//add in the graph with neighbours
				graph_not_included[i][1] = second_vertex;
				//maintain the weight of the edge
				graph_not_included[i][2] = weight_in;
				//maintain 0 it is not included
				graph_not_included[i][3] = include_F;

			}

		}
		//function call to the minimum cost calculation of spaning tree
		System.out.println(min_cost_cal(vertices, edges, graph, end_index, graph_not_included));
		//Scanner closing
		sc.close();
	}

}


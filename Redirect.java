/***
 *class that finds edge to be connected to make the complete graph structure strongly connected
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

public class Redirect {
	//Number of vertices in the graph
	static int vertices;
	//stack that maintains in the input of the strongly connected components
	static int[] stack_nodes;
	//array that shows which are strongly connected components
	static int[] array_connected_nodes;
	//the number that maintains count of the stack
	static int count = 0;
/**
 * Method that performs DFS to find the nodes to be in stack
 * @param current_node	 current node to perform DfS
 * @param visited		array that maintains visited nodes 
 * @param end_index		array that keeps count of neighbours of each node
 * @param graph			graph structure
 */
	public static void DFS(int current_node, boolean[] visited,
			int[] end_index, int[][] graph) {
		//make the visited node true
		visited[current_node] = true;
		//System.out.println(Arrays.toString(visited));
		// System.out.println(stack[count]);
		//loop that finds the neighbors that maintain the visited array and go through neighbors performing DFS
		for (int i = 0; i < end_index[current_node]; i++) {
			// its neighbour stored in the next index variable
			int next_index = graph[current_node][i];
			// if visited is false
			if (visited[next_index] == false) {
				// visited[next_index]=true;
				// recursive call to dfs function
				DFS(next_index, visited, end_index, graph);
			}
		}
		//maintain the nodes in the stack 
		stack_nodes[count] = current_node;
		//maintain the count of the stack
		count = count + 1;
	}
/**
 * DFS to check and find strongly connected components groups
 * @param current_node		current node to find DFS
 * @param visited_reverse	reversed graph visited array
 * @param end_index_reverse	maintaining neighbors of the node
 * @param reverse_graph		reverse graph structure
 * @param number_SCC		finding the count of strogly connected components
 */
	public static void DFS_of_reverse_graph(int current_node,
			boolean[] visited_reverse, int[] end_index_reverse,
			int[][] reverse_graph, int number_SCC) {
		//to make the current node visited
		visited_reverse[current_node] = true;
		array_connected_nodes[current_node] = number_SCC;
		//loop that performs DFS and finds its neighbors
		for (int i = 0; i < end_index_reverse[current_node]; i++) {
			int next_index = reverse_graph[current_node][i];
			// condition executes if node not visited
			if (visited_reverse[next_index] == false) {
				DFS_of_reverse_graph(next_index, visited_reverse,
						end_index_reverse, reverse_graph, number_SCC);
			}
		}
		// for every node it is connected to in reverse G

	}
/**
 * DFS to find if the whole graph is strongly connected or not
 * @param current_node		the current node to perform DFS
 * @param visited_to_SCC	visited node of the strongly connected components
 * @param end_index_reverse	maintaining the neighbors
 * @param reverse_graph		reverse graph structure
 */
	public static void DFS_to_find_strongly_connected(int current_node,
			boolean[] visited_to_SCC, int[] end_index_reverse,
			int[][] reverse_graph) {
		//current visited node marked as true
		visited_to_SCC[current_node] = true;
		//loop to find its neighbors and perform DFS
		for (int i = 0; i < end_index_reverse[current_node]; i++) {
			int next_index = reverse_graph[current_node][i];
			if (visited_to_SCC[next_index] == false) {
				DFS_to_find_strongly_connected(next_index, visited_to_SCC,
						end_index_reverse, reverse_graph);
			}

		}
	}
/**
 * Method that finds the edge and whether the graph is strongly connected or not
 */
	public static void find_edge_connection(int[][] graph, int vertices,
			boolean[] visited, int[] end_index, int[][] reverse_graph,
			boolean[] visited_reverse, int[] end_index_reverse,
			boolean[] visited_to_SCC) {
		//loop that finds the nodes order in the stack of the strongly connected components
		for (int i = 1; i < visited.length; i++) {
			//System.out.println(i);
			if (visited[i] == false) {
				//performing DFS
				DFS(i, visited, end_index, graph);
			}

		}
		
		//the variable that keeps count of strongly connected components in the graph
		int number_SCC = 0;
		//loop that finds strongly connected components
		for (int i = stack_nodes.length - 1; i >= 0; i--) {
			if (visited_reverse[stack_nodes[i]] == false) {
				DFS_of_reverse_graph(stack_nodes[i], visited_reverse,
						end_index_reverse, reverse_graph, number_SCC);
				number_SCC = number_SCC + 1;
				
			}
		}
		
		//the first edge to be connected
		int node_to_be_connected_01 = stack_nodes[stack_nodes.length - 1];
		//System.out.println(node_to_be_connected_01);
		int node_to_be_connected_02 = stack_nodes[stack_nodes[0]];
			//loop that finds the two edges to be connected
		int i=1;
		//loop to check if the graph is strongly connected or not
		while(i < array_connected_nodes.length)
		 {
		  if(array_connected_nodes[i]==number_SCC-1){
		  node_to_be_connected_02=i;
		  break;
		  }
		  i=i+1;
		  }
		
		//System.out.println(node_to_be_connected_02);
		//graph[node_to_be_connected_02][end_index_reverse[node_to_be_connected_02]+1] = node_to_be_connected_01;
		  //command that connects the edge
		reverse_graph[node_to_be_connected_01][end_index_reverse[node_to_be_connected_01]] = node_to_be_connected_02;
		end_index_reverse[node_to_be_connected_01]++;
		
		//answer variable
		boolean answer = true;
		//DFS to check wether the graph is connected to all nodes
		DFS_to_find_strongly_connected(node_to_be_connected_02, visited_to_SCC,
				end_index_reverse, reverse_graph);
		
		//loop to check if the graph is strongly connected or not
		for (int j = 1; j < visited_to_SCC.length; j++) 
		 {
			//if the visited array any component false i.e. not reachable
			if (visited_to_SCC[j] == false) {
				answer = false;
				//print no
				System.out.println("NO");
				break;
			}

		}
		//if all nodes are connected
		if (answer == true) {
			System.out.println("YES");
			//print both components
			System.out.println(node_to_be_connected_01+" "+node_to_be_connected_02);
		}
		

	}
	/**
	 * Main Method the driver program
	 * @param args
	 */
	public static void main(String[] args) {
		//Scanner class
		Scanner sc = new Scanner(System.in);
		//vertices input
		vertices = sc.nextInt();
		//stack that maintains the order of connected nodes
		stack_nodes = new int[vertices];
		//array that maintains the strongly connected groups
		array_connected_nodes = new int[vertices + 1];
		//visited array to find the order of components in the graph
		boolean visited[] = new boolean[vertices + 1];
		//visited array to find the scc usinhg DFS
		boolean visited_reverse[] = new boolean[vertices + 1];
		//array that finds whether whole graph is strongly connected after adding the edge
		boolean visited_to_SCC[] = new boolean[vertices + 1];
		// loop to go through the vertices
		for (int i = 1; i <= vertices; i++) {
			//mark all the nodes false
			visited[i] = false;
			visited_reverse[i] = false;
			visited_to_SCC[i] = false;
		}
		//graph structure
		int[][] graph = new int[vertices + 1][vertices + 1];
		//reverse graph structure transpose of graph
		int[][] reverse_graph = new int[vertices + 1][vertices + 1];
		//maintaining the neighbors count
		int[] end_index = new int[vertices + 1];
		int[] end_index_reverse = new int[vertices + 1];
		int[] current_vertex = new int[vertices + 1];
		//loop that takes the input
		for (int i = 1; i <= vertices; i++) {

			int preq = sc.nextInt();

			// while the input line is zero that indicates to go to next row
			while (preq != 0) {
				reverse_graph[preq][end_index_reverse[preq]] = i;
				end_index_reverse[preq]++;
				// the end index of the vertex given the preq
				current_vertex[end_index[i]] = preq;
				// end index value for that node increased
				end_index[i]++;
				// incoming entries of that node increased
				// values input for that node in the input row loop continues
				// till it is zero
				preq = sc.nextInt();

			}
			// Used to set the size of array of array
			graph[i] = Arrays.copyOfRange(current_vertex, 0, end_index[i]);

		}

		
		//method to find the edge connection and find the graph is strongly connected 
		find_edge_connection(graph, vertices, visited, end_index,
				reverse_graph, visited_reverse, end_index_reverse,
				visited_to_SCC);
		//close the scanner class
		sc.close();
	}
}

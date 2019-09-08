/***
 *class that finds the number of shortest path to reach the destination from source
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

public class NumPaths {
/**
 * 
 * @param graph			the array of array storing neighbours of each node
 * @param end_index		array which stores the value of number of neighbours per node
 * @param source		the source node to start 
 * @param destination	the destination node to reach
 */


	private static void BFS(int[][] graph, int[] end_index, int source, int destination) {
		//the start , end index intialized
		int start = 0, end = 1;
		//the queue array which maintains the values in the queue to perform bfs
		int[] queue = new int[end_index.length];
		//the cost array which maintains the value of the number of paths to that particular node
		int[] cost = new int[end_index.length];
		//boolean array that maintains node is visited/ not visited
		boolean[] visited = new boolean[end_index.length];
		//array that maintains the count of the reach to the node
		int[] countOfReach = new int[end_index.length];
		//queue starts with the source 
		queue[start] = source;
		//start of cost with source 0
		cost[source] = 0;
		//visited source in the array true
		visited[source] = true;
		//currently count of reach 1
		countOfReach[source] = 1;
		//loop till start is not equal to end
		while(start != end) {
			//current vertex the current value in queue 
			int current_vertex = queue[start];
			//loop to get all the neighbours of the vertex
			for(int i = 0; i < end_index[current_vertex]; i++) {
				//get the neighbours
				int next_index = graph[current_vertex][i];
				//if the nodes are not visited
				if(visited[next_index] == false) {
					//condition count of reach is zero
					if(countOfReach[next_index] == 0) {
						//give the value of count of reach of the vertex it has come from to current vertex
						countOfReach[next_index] = countOfReach[current_vertex];

					}
					//cost of neighbour current is cost of current vertex plus 1
					cost[next_index] = cost[current_vertex] + 1;
					//the queue of end is next index
					queue[end] = next_index;
					//increase the end value according to the neighbour
					end ++;
					//then mark the visited nodes true
					visited[next_index] = true;

				} else {
					//if it is visited then the followng condition is executed
					//the cost of the neighbour is one plus the current vertex equal
					if(cost[next_index] == cost[current_vertex] + 1) {
						//count of reach is updated as follows
						countOfReach[next_index] += countOfReach[current_vertex];

					}

				}

			}
			//start index increased 
			start++;

		}
		//prints the output of count of reach array of the index of destination
		System.out.println(countOfReach[destination]);
	}
/**
 * Main Method that runs the program
 * @param args
 */
	public static void main(String[] args) {
		//Scanner class to take the input
		Scanner sc = new Scanner(System.in);
		//number of vertices for graph
		int vertices = sc.nextInt();
		//number of edges in the graph
		int edges = sc.nextInt();
		//source point from where to start
		int source = sc.nextInt();
		//destination node in the graph to reach
		int destination = sc.nextInt();
		// Start and End Index
		//End Index array that keeps the count of the end index on that node
		int[] end_index = new int[vertices + 1];
		//graph that is array of array intialized to max number of edges in order to store its neighbours
		int[][] graph = new int[vertices+1][vertices+1];
		//loop that takes the input for the graph
		for(int i = 0; i < edges; i++) {
			//the node on which we have to add neighbours
			int first_vertex = sc.nextInt();
			//neighbours of the first selected node
			int second_vertex = sc.nextInt();
			//finds the place in graph and stores it in array of array
			graph[first_vertex][end_index[first_vertex]] = second_vertex;
			//stores it vice-versa way
			graph[second_vertex][end_index[second_vertex]] = first_vertex;
			//maintaining end index of first index 
			end_index[first_vertex]++;
			//maintaining end index of second index
			end_index[second_vertex]++;
		}
		//BFS applied to the graph function call
		BFS(graph, end_index, source, destination);
		//closing the scanner class
		sc.close();
	}

}
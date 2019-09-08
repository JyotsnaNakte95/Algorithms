/***
 *class that finds the number of longest prerequisite chain to take courses
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */

import java.util.Arrays;
import java.util.Scanner;
public class Prerequisites {
/**
 * 
 * @param vertices			vertices of the graph
 * @param graph				graph structure maintains nodes with neighbour
 * @param end_index			end index array that maintains number of neighbours
 * @param incoming_degree	array that maintains number of incoming values of the node
 */
	public static void longest_path(int vertices, int[][] graph, int[] end_index, int[] incoming_degree) {
		//longest path 
		int LPT[] = new int[vertices + 1];
		//the queue array which maintains the values of the input coming
		int[] queue = new int[vertices + 1];
		//start , end index 
		int start = 0;
		int end = 0;
		//longest path 
		int longest_path = 0;
		//loop from first vertice to end
		for(int i = 1; i <= vertices; i++) {
			//if number of incoming degree value is zero
			if(incoming_degree[i] == 0) {
				//then put it in the queue
				queue[end] = i;
				//increase the end index
				end ++;

			}

		}
		//loop start not equal to end
		while(start != end) {
			//head is given to the queue start
			int head = queue[start];
			//get its neigbours value
			for(int j = 0; j < end_index[head]; j++) {
				//give the next_index values
				int next_index = graph[head][j];
				//decrease the incoming degree
				incoming_degree[next_index]--;
				//find the maximum between current node or previous+1
				LPT[next_index] = Math.max(LPT[next_index], 1 + LPT[head]);
				//value maintaining the longest path
				longest_path = Math.max(longest_path, LPT[next_index]);
				//if the incoming degree is zero
				if(incoming_degree[next_index] == 0) {
					//then add the values to the queue
					queue[end] = next_index;
					//increase the end index
					end++;

				}

			}
			//increase the start index
			start++;

		}
		//print the longest path found, add one for the node itself
		System.out.println(longest_path + 1);

	}
/**
 * Main Method that runs the program
 * @param args
 */
	public static void main(String[] args) {
		//Scanner class that takes the input
		Scanner sc = new Scanner(System.in);
		//number of vertices in the graph
		int vertices = sc.nextInt();
		//array of array graph structure that stores the nodes with its neighbours 
		int[][] graph = new int[vertices + 1][];
		//current vertex array that stores the value of the neighbours
		int[] current_vertex = new int[vertices + 1];
		//array that maintains the number of neighbours each node when input is being scanned
		int[] end_index = new int[vertices + 1];
		//array that maintains the number of inputs to that node/prerequiste needed for that course
		int[] incoming_degree = new int[vertices + 1];
		//loop for the number of vertices in the graph to take input
		for (int i = 1; i <= vertices; i++) {
			//we take the first input
			int preq = sc.nextInt();
			//while the input line is zero that indicates to go to next row
			while(preq != 0) {
				//the end index of the vertex given the preq
				current_vertex[end_index[i]] = preq;
				//end index value for that node increased
				end_index[i]++;
				//incoming entries of that node increased
				incoming_degree[preq] ++;
				//values input for that node in the input row loop continues till it is zero
				preq = sc.nextInt();

			}
			//Used to set the size of array of array
			graph[i] = Arrays.copyOfRange(current_vertex, 0, end_index[i]);

		}

		//System.out.println(Arrays.deepToString(graph));

		longest_path(vertices, graph, end_index, incoming_degree);

		sc.close();

	}

}
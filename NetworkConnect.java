import java.util.Arrays;
import java.util.Scanner;


public class NetworkConnect {

	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int vertices= sc.nextInt();
		int edges=sc.nextInt();
		int number_of_servers=sc.nextInt();
		int number_of_users=sc.nextInt();
		int[] end_index = new int[vertices + 1];
		int[][] graph = new int[edges][3];
		//loop that takes the input for the graph
		for (int i = 0; i < edges; i++) {
			//first node to take input
			int first_vertex = sc.nextInt();
			//the neighbour of the node
			int second_vertex = sc.nextInt();
			//weight of the edge
			int bandwidth = sc.nextInt();
			graph[i][0] = first_vertex;
			//add in the graph with neighbours
			graph[i][1] = second_vertex;
			//maintain the weight of the edge
			graph[i][2] = bandwidth;
			
		}
		System.out.println(Arrays.deepToString(graph));
		
	}
}

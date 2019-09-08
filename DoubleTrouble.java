/***
 *class that finds  the smallest number of moves thing One and thing Two need to get out of the house
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */

import java.util.Scanner;
//Point class having values x, y, cost
class Point {
	//global variables
	int x, y, cost;
/**
 *Constructor of the class 
 */
	Point(int x, int y, int cost) {
		//values updated according to current object of the class
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}

public class DoubleTrouble {
	//global variables declared
	//number of rows
	static int a;
	//number of columns in the row
	static int b;
	//graph structure 
	static int[][] graph;
	//first queue for thing 1
	static Point[] first_queue;
	//second queue for thing 2
	static Point[] second_queue;
	//boolean array if visited
	static boolean[][][][] visited;
	//cost of the array
	static int cost;
	//count to keep check if way found or not 
	static int count = 0;
	//start index initiated
	static int start_index = 0;
	//end index initiated
	static int end_index = 1;
/**
 * Boolean Method to check if it is out of bound or not
 * */
	public static boolean checkForOutOfBound(int x, int y) {

		return x >= 0 && y >= 0 && x < a && y < b;

	}
/**
 * Boolean Method to check wall  
 * 
 */
	public static boolean checkForWall(int x1, int y1, int x2, int y2) {

		return !(graph[x1][y1] == 1 && graph[x2][y2] == 1);

	}
/**
 * Method if only one of the thing can move
 */
	public static boolean checkForAdd(int x1, int y1, int x2, int y2, int offset_x, int offset_y) {

		return (graph[x1][y1] == 1 && !(x2 == x1 + offset_x && y2 == y1 + offset_y));

	}
/**
 * Method for adding the values in the queues
 * @param x1	x coordinate of thing 1
 * @param y1	y coordinate of thing 1
 * @param x2	x coordinate of thing 2
 * @param y2	y coordinate of thing 2
 * @param cost	cost of the path
 */
	public static void add(int x1, int y1, int x2, int y2, int cost) {
		//values added to the firt queue
		first_queue[end_index] = new Point(x1,y1,cost+1);
		//values added to the second queue
		second_queue[end_index] = new Point(x2,y2,cost+1);
		//end index updated
		end_index++;
		//visited array updated to the values added i.e., visited as true
		visited[x1][y1][x2][y2] = true;

	}
/**
 * 
 * @param x1		x-coordinate of thing 1
 * @param y1		y-coordinate of thing 1
 * @param x2		x-coordinate of thing 2
 * @param y2		y-coordinate of thing 2
 * @param offset_x	the offset amount added/subtracted to one point
 * @param offset_y	the offset amount added/subtracted to one point
 * @param current_cost	current cost of the co-ordinate
 */
	public static void check(int x1, int y1, int x2, int y2, int offset_x, int offset_y, int current_cost) {
		//the if condition to check weather both the thing 1,2 are out of bound reached the door to get out
		if (!checkForOutOfBound(x1, y1) && !checkForOutOfBound(x2, y2)) {
			//count is set to one
			count = 1;
			//cost is updated to current cost
			cost = current_cost + 1;
		}
		//the if condition checking for out of bound, checking for wall if there is no wall
		if (checkForOutOfBound(x1, y1) && checkForOutOfBound(x2, y2)  && checkForWall(x1, y1, x2, y2)) {
			//if condition that no wall and both can move
			if (graph[x1][y1] == 0 && graph[x2][y2] == 0 && !(x1 == x2 && y1 == y2) && !visited[x1][y1][x2][y2]) {
				//add them in queue
				add(x1, y1, x2, y2, current_cost);
			} else {
				//if only thing one can move
				if (checkForAdd(x1, y1, x2, y2, offset_x, offset_y) && !visited[x1 + offset_x][y1 + offset_y][x2][y2]) {
					//add them in the queue
					add(x1 + offset_x, y1 + offset_y, x2, y2, current_cost);
				}
				//if only thing two can move
				if (checkForAdd(x2, y2, x1, y1, offset_x, offset_y) && !visited[x1][y1][x2 + offset_x][y2 + offset_y]) {
					//add them in the queue
					add(x1, y1, x2 + offset_x, y2 + offset_y, current_cost);
				}
			}
		}
	}
/**
 * 
 * Method of calculating minimum steps to get out of graph
 */
	public static void calculate() {

		// Start 1 Queue Index
		//base case
		while (start_index != end_index) {
			//first queue item removed
			Point firstLoc = first_queue[start_index];
			//second queue item removed
			Point secondLoc = second_queue[start_index];
			//check the points of both thing one, two above,below,right,left
			check(firstLoc.x + 1, firstLoc.y, secondLoc.x + 1, secondLoc.y, -1, 0, firstLoc.cost);
			check(firstLoc.x, firstLoc.y + 1, secondLoc.x, secondLoc.y + 1, 0, -1, firstLoc.cost);
			check(firstLoc.x - 1, firstLoc.y, secondLoc.x - 1, secondLoc.y, 1, 0, firstLoc.cost);
			check(firstLoc.x, firstLoc.y - 1, secondLoc.x, secondLoc.y - 1, 0, 1, firstLoc.cost);
			//if conditions executed properly increase the start index
			start_index++;
			//if it reaches the boundary to get out, count is zero then break
			if (count == 1) {
				break;
			}
		}
		//if the count 0 it is stuck somewhere cannot move
		if (count == 0) {
			//print STUCK
			System.out.println("STUCK");
		} else {
			//print the minimum cost to get out
			System.out.println(cost);

		}		
		//System.out.println(count);

		//System.out.println(cost);

	}
/**
 * Main Method driver of the program start point
 * @param args
 */
	public static void main(String[] args) {
		//Scanner class to take the input
		Scanner sc = new Scanner(System.in);
		//the number of rows
		a = sc.nextInt();
		//the number of columns
		b = sc.nextInt();
		//graph structure initialized
		graph = new int[a][b];
		//first queue initialized
		first_queue = new Point[a * a * b * b];
		//second queue initialized
		second_queue = new Point[a * a * b * b];
		//visited array boolean visited
		visited = new boolean[a][b][a][b];
		//for loop to take input run the number of rows
		for (int i = 0; i < a; i++) {
			//taking input by line
			String current_point = sc.next();
			//converting it into character array
			char[] point = current_point.toCharArray();
			//loop for the characters in each row
			for (int j = 0; j < b; j++) {
				//if there is graph to move around we replace with 0
				if (current_point.charAt(j) == '.')
					graph[i][j] = 0;
				//if the graph has X it has wall so it is replaced with 1
				if (point[j] == 'x')
					graph[i][j] = 1;
				//if the graph gets characer one then it is the first thing 
				if (point[j] == '1') {
					//entered in the fist queue graph stored as 0
					first_queue[0] = new Point(i,j,0);
					graph[i][j] = 0;
				}
				//if graph gets character 2 then stored as 0
				if (point[j] == '2') {
					graph[i][j] = 0;
					//entered in second queue
					second_queue[0] = new Point(i,j,0);
				}

			}

		}
		//the visited boolean array on the both place is marked as true
		visited[first_queue[0].x][first_queue[0].y][second_queue[0].x][second_queue[0].y] = true;
		//function call for calculate
		calculate();
		//close the scanner class
		sc.close();

	}

}
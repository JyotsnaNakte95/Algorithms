/***
 *class that finds the minimum weight for upto the cost given
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */

import java.util.Scanner;

//import java.util.math;
public class MinWeightKnapsack {
/**
 * 
 * @param n				Number of the items
 * @param C				Cost of the upto given
 * @param cost			the cost array
 * @param weight		the weight array
 * @param min_weight	Solution array of the minimum weight
 */
	public void find_min_weights(int n, int C, int[] cost, int[] weight, int[][] min_weight) {
		//loop for every row
		for (int v = 1; v <= n; v++) {
			//loop for the cost given
			for (int k = 1; k <= C; k++) {
				//minimum weight of the above element stored as default
				min_weight[v][k] = min_weight[v - 1][k];
				//if the weight is less than current cost than find the minimum for the given cost
				if (weight[v-1] < k) {
					min_weight[v][k] = Math.min(min_weight[v - 1][k - weight[v-1]] + cost[v-1], min_weight[v][k]);
				} else {
					//find the minimum between cost and previous stored value
					if(weight[v-1] >= k) {
						min_weight[v][k] = Math.min(cost[v-1], min_weight[v][k]);
					}
				}
			}
		}
		//print the minimum weight for the given cost
		System.out.println(min_weight[n][C]);
	}
/**
 * Main Method
 * @param args
 */
	public static void main(String[] args) {
		//Scanner class that takes the input
		Scanner sc = new Scanner(System.in);
		//Number of items
		int n = sc.nextInt();
		//the Cost
		int C = sc.nextInt();
		//Weight array
		int[] weight = new int[n];
		//cost array
		int[] cost = new int[n];
		//take the inputs
		for (int i = 0; i < n; i++) {
			weight[i] = sc.nextInt();
			cost[i] = sc.nextInt();

		}
		
		//Solution Array to store the results
		int[][] min_weight = new int[n+1][C+1];
		//loop for initializing to higher number inorder to find minimum
		for (int i = 0; i <= C; i++) {
			min_weight[0][i] = 100000;
		}
		//initializing to zero base case
		for (int i = 0; i <= n; i++) {
			min_weight[i][0] = 0;
		}
		//creating the object of the class
		MinWeightKnapsack mwk = new MinWeightKnapsack();
		//the method call
		mwk.find_min_weights(n, C, weight, cost, min_weight);
		
	}
}
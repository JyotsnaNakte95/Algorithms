/***
 *class that finds the minimum cost for triangulation of a convex polygon is a set of n − 3 non-intersecting
edges, where each edge connects two non-consecutive vertices ,the overall picture consists
of n − 2 triangles that together form the original polygon 
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */
import java.util.Scanner;

public class Triangulation {
/**
 * Method compares two attributes that finds the minimum
 * @param x	One attribute
 * @param y Second Attribute
 * @return minimum element
 */
	public static double min(double x, double y) {
		//condition check which is greater
		if (x > y) {
			return y;
		}
		return x;

	}
/***
 * Method that finds the minimum cost of triangulation
 * @param n			Number of edges
 * @param min_dist	Solution array that maintains the minimum cost 
 * @param x			The x co-ordinates
 * @param y			The y co-ordinates
 */
	public void find_min_dist(int n, double[][] min_dist, double[] x, double[] y) {
		//loop for every vertex
		for (int i = 0; i < n; i++) {
			//counter every row
			int j = 0;
			//loop for non-consecutive pairs
			for (int k = i + 2; k < n; k++) {
				//Set the value to Max Value
				min_dist[j][k] = Double.MAX_VALUE;
				//trying minimum distance for all possiblities
				for (int l = j + 1; l < k; l++) {
					
					//the value of minimum cost for triangulation stored
					if (j == 0 && k == n - 1) {
						min_dist[j][k] = min(min_dist[j][k], min_dist[j][l]
								+ min_dist[l][k]);

					} else {
						//computation of cost for various lengths using previous results and euclidean's distance
						min_dist[j][k] = min(
								min_dist[j][k],
								min_dist[j][l]
										+ min_dist[l][k]
										+ Math.abs(Math.sqrt(Math.pow(
												(x[j] - x[k]), 2)
												+ Math.pow((y[j] - y[k]), 2))));
					}

				}
				//counter increased by 1
				j = j + 1;
			}

		}

		
		//storing the value
		double a = min_dist[0][n - 1];
		//formating upto four digits
		double minimum_cost = (double) Math.round(a * 10000) / 10000;
		System.out.println(minimum_cost);
	}
/**
 * Main Method that the program works
 * @param args
 */
	public static void main(String[] args) {
		//Scanner class for input
		Scanner sc = new Scanner(System.in);
		//number of vertices
		int n = sc.nextInt();
		//x co-ordinates
		double[] x = new double[n];
		//y co-ordinates
		double[] y = new double[n];
		//loop for storing values
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextFloat();
			y[i] = sc.nextFloat();
		}
		//object of the class
		Triangulation t = new Triangulation();
		//Solution array to store results and find minimum length
		double[][] min_dist = new double[n + 1][n + 1];
		//function call to find minimum array
		t.find_min_dist(n, min_dist, x, y);

	}
}

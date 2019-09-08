/***
 *class that finds the longest increasing subsequence recursively  
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */

import java.util.Scanner;



public class LongestIncreasingSubseqRecursive {
	//Maximum variable 
	int max = 0;
	/**
	 * 
	 * @param n			Number of elements in the array
	 * @param numbers	Numbers array
	 * @param length_count_to_be_considered_max length of the maximum
	 * @return the maximum length of increasing longest sequence
	 */
	public int incrSubseqRecursive(int n, int[] numbers, int length_count_to_be_considered_max) {
		//counter to keep count
		int counter = 1;
		//if the element is one
		if (n == 1) {

			return 1;

		}
		//loop to check longest increasing sequence
		for (int i = 1; i < n; i++) {
			//recursive function
			counter = incrSubseqRecursive(i, numbers, 1);
			//if condition
			if (numbers[i - 1] < numbers[n - 1] && counter + 1 > length_count_to_be_considered_max) {

				length_count_to_be_considered_max = counter + 1;

			}


			//condition checks for max
			if (max < length_count_to_be_considered_max) {

				max = length_count_to_be_considered_max;

			}



		}
		//return the maximum length
		return length_count_to_be_considered_max;

	}


/**
 * Main Method
 * @param args
 */
	public static void main(String[] args) {
		//long start = System.currentTimeMillis();
		//Scanner class
		Scanner sc = new Scanner(System.in);
		//number of elements
		int n = sc.nextInt();
		//elements in the array
		int[] numbers = new int[n];
		//stores in the array
		for (int i = 0; i < n; i++) {

			numbers[i] = sc.nextInt();

		}
		//object of class
		LongestIncreasingSubseqRecursive lr = new LongestIncreasingSubseqRecursive();
		//returns the max_length
		int max_length = lr.incrSubseqRecursive(n, numbers, 1);
		//prints the maximum length of longest increasing array
		System.out.println(lr.max);
		//long time = System.currentTimeMillis() - start;
		//System.out.println("Time taken to execute:" +time);

	}

}
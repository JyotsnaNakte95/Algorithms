/***
 * class that returns sums of the numbers having maximum pair
 * 
 *  @author jyotsna namdeo nakte jnn2078
 */
import java.util.Scanner;
public class FindMaxPairs {
	/**
	 * method that sorts and merges the array in descending order
	 * 
	 * @param ar 			array to be sorted
	 * @param lowpoint		start of array
	 * @param midpoint		mid of the array
	 * @param highpoint		end of the array
	 */
	public void merge(long ar[], int lowpoint, int midpoint, int highpoint) {
		int first_subarray = midpoint - lowpoint, second_subarray = highpoint
				- midpoint + 1;
		long left[] = new long[first_subarray];
		long right[] = new long[second_subarray];
		int k = lowpoint, i = 0, j = 0;
		// loop for the left part of array
		for (int m = 0; m < first_subarray; m++) {
			left[m] = ar[lowpoint + m];
		}
		// loop for the right part of array
		for (int n = 0; n < second_subarray; n++) {
			right[n] = ar[midpoint + n];
		}

		while (i < first_subarray && j < second_subarray) {
			// condition that stores higher number first
			if (left[i] >= right[j]) {
				ar[k] = left[i];
				i++;
			} else {
				ar[k] = right[j];
				j++;
			}
			k++;

		}
		if (i < first_subarray) {
			while (i < first_subarray) {
				ar[k] = left[i];
				i++;
				k++;
			}
		} else {
			while (j < second_subarray) {
				ar[k] = right[j];
				j++;
				k++;
			}
		}
	}

	/**
	 * method to sort the array in descending order
	 * 
	 * @param ar 			array to be sorted
	 * @param lowpoint		start of array
	 * @param highpoint		end of the array
	 */
	public void sort(long ar[], int lowpoint, int highpoint) {
		//base condition
		if (lowpoint < highpoint) {
			//finding mid
			int midpoint = (lowpoint + highpoint + 1) / 2;
			//recursive calls
			sort(ar, lowpoint, midpoint - 1);
			sort(ar, midpoint, highpoint);
			//merging
			merge(ar, lowpoint, midpoint, highpoint);
		}

	}

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//object of the class
		FindMaxPairs fp = new FindMaxPairs();
		//Scanner class object
		Scanner sc = new Scanner(System.in);
		//counter that counts number of pairs of same sum
		int counter = 1;
		//maintains the max count of the sum of pairs
		int max = 1;
		//maintains the value of  sum that has maximum pairs
		long big_sum = 0;
		//input number of integers in the array
		int n = sc.nextInt();
		//value that square of n integers in array
		int value = n * n;
		//to maintain length of pairs_sum array
		int m = 0;
		//takes the element as input
		int numbers[] = new int[n];
		//loop that stores elements in array
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		//creates n^2 array to store sum
		long pairs_sum[] = new long[value];
		//loop that finds pairs
		for (int k = 0; k < numbers.length; k++) {
			for (int l = k + 1; l < numbers.length; l++) {
				pairs_sum[m] = (long)numbers[k] + (long)numbers[l];
				m++;
			}
		}
		//sorts the array in descending order
		fp.sort(pairs_sum, 0, m - 1);
		//loop finds the sum that has maximum pairs
		for (int r = 0; r < m; r++) {
			//condition to increases counter if come across same number to maintain maximum pairs sum count
			if (pairs_sum[r] == pairs_sum[r + 1] && r != m - 1) {
				counter = counter + 1;
			}
			else {
				//condition if the max is less than counter
				if (max <= counter) {
					//updates the sum
					big_sum = pairs_sum[r];
					//updates the max
					max = counter;
				}
				//reset counter to 1 to count for new sum number
				counter = 1;
			}
		}
		//prints the value of sum that has maximum pairs in the array
		System.out.println(big_sum);
	}
}
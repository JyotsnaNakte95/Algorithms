/***
 * class to find whether it is possible to shift all filled planters
 * 
 * @author jyotsna namdeo nakte jnn2078
 * 
 */

import java.util.Scanner;

public class Planters {
	/**
	 * method that sorts and merges the array in descending order
	 * 
	 * @param ar 			array to be sorted
	 * @param lowpoint		start of array
	 * @param midpoint		mid of the array
	 * @param highpoint		end of the array
	 */
	public void merge(int ar[], int lowpoint, int midpoint, int highpoint) {
		int first_subarray = midpoint - lowpoint, second_subarray = highpoint
				- midpoint + 1;
		int left[] = new int[first_subarray];
		int right[] = new int[second_subarray];
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
	 * method to sort the array
	 * 
	 * @param ar 			array to be sorted
	 * @param lowpoint		start of array
	 * @param highpoint		end of the array
	 */
	public void sort(int ar[], int lowpoint, int highpoint) {
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
	public static void main(String args[]) {
		// scanner class
		Scanner sc = new Scanner(System.in);
		// object of class made
		Planters pl = new Planters();
		// number of p plants
		int p = sc.nextInt();
		// number of r extra pots
		int r = sc.nextInt();
		// array to check if empty
		int check[] = new int[p + r];
		// array that stores planters
		int s[] = new int[p];
		// counter to check if all conditions satisfied
		int count = 0;
		// loop that takes elements in array from command line
		for (int i = 0; i < p; i++) {
			s[i] = sc.nextInt();
			check[i] = s[i];

		}
		// array for the extra plants
		int t[] = new int[r];
		for (int l = 0; l < r; l++) {
			t[l] = sc.nextInt();
			check[p + l] = t[l];
		}
		// sorting both arrays in descending order
		pl.sort(s, 0, s.length - 1);
		pl.sort(check, 0, check.length - 1);
		for (int x = 0; x < s.length; x++) {
			// condition to check if empty and fits in continues the loop
			if (s[x] < check[x]) {
				continue;
			} else {
				count = 1;
				break;
			}
		}
		// if counter zero it has got place for all the planters
		if (count == 0) {
			System.out.println("YES");

		} else {
			System.out.println("NO");

		}

	}
}

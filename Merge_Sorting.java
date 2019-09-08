import java.util.Scanner;


public class Merge_Sorting {
	public void merge(int ar[], int lowpoint, int midpoint, int highpoint) {
		int first_subarray = midpoint - lowpoint, second_subarray = highpoint - midpoint + 1;
		int left[] = new int[first_subarray];
		int right[] = new int[second_subarray];
		int k = lowpoint, i = 0, j = 0;

		for (int m = 0; m < first_subarray; m++) {
			left[m] = ar[lowpoint + m];
		}
		for (int n = 0; n < second_subarray; n++) {
			right[n] = ar[midpoint + n];
		}

		while (i < first_subarray && j < second_subarray) {
			if (left[i] <= right[j]) {
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

	public void sort(int ar[], int lowpoint, int highpoint) {
		if (lowpoint < highpoint) {
			int midpoint = (lowpoint + highpoint + 1) / 2;
			sort(ar, lowpoint, midpoint - 1);
			sort(ar, midpoint, highpoint);
			merge(ar, lowpoint, midpoint, highpoint);
		}

	}

	public void print_array(int array[]) {
		for (int e = 0; e < array.length; e++) {
			System.out.println(array[e]);
		}

	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter p:");
		Merge_Sorting ms = new Merge_Sorting();
		int p = sc.nextInt();
		int s[] = new int[p];
		for (int i = 0; i < p; i++) {
			s[i] = sc.nextInt();
		}
		ms.sort(s, 0, s.length - 1);
		System.out.println("After sorting s:");
		ms.print_array(s);

	}
}

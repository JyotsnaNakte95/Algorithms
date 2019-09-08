
public class Sorting_multiple {
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


}

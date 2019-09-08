/***
 *class that finds the maximum non-overlapping intervals 
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */

import java.util.Scanner;
public class IntervalsBreaks {
/**
 * Merge the sorted array 
 * @param finish 	finish array that maintains the finish time
 * @param lowpoint	low point the start of the array
 * @param midpoint	mid of the array found
 * @param highpoint	high point the end of the array
 * @param start		start array that maintains the start time
 * @param counter_time_interval array that maintains counter of interval
 */

	public void merge(int finish[], int lowpoint, int midpoint, int highpoint, int[] start, int[] counter_time_interval) {
		
		int first_subarray = midpoint - lowpoint, second_subarray = highpoint - midpoint + 1;

		int left_finish[] = new int[first_subarray];

		int right_finish[] = new int[second_subarray];

		int left_start[] = new int[first_subarray];

		int right_start[] = new int[second_subarray];

		int left_count_interval[] = new int[first_subarray];

		int right_count_interval[] = new int[second_subarray];

		int k = lowpoint, i = 0, j = 0;
		//loop creating left of array
		for (int m = 0; m < first_subarray; m++) {

			left_finish[m] = finish[lowpoint + m];

			left_start[m] = start[lowpoint + m];

			left_count_interval[m] = counter_time_interval[lowpoint + m];

		}
		//loop creating for right of array
		for (int n = 0; n < second_subarray; n++) {

			right_finish[n] = finish[midpoint + n];

			right_start[n] = start[midpoint + n];

			right_count_interval[n] = counter_time_interval[midpoint + n];

		}


		//loop that sorts value and stores
		while (i < first_subarray && j < second_subarray) {

			if ((left_finish[i] < right_finish[j]) || (left_finish[i] == right_finish[j] && left_start[i] < right_start[j])) {

				finish[k] = left_finish[i];

				start[k] = left_start[i];

				counter_time_interval[k] = left_count_interval[i];

				i++;

			} else {

				finish[k] = right_finish[j];

				start[k] = right_start[j];

				counter_time_interval[k] = right_count_interval[j];

				j++;

			}

			k++;



		}

		if (i < first_subarray) {

			while (i < first_subarray) {

				finish[k] = left_finish[i];

				start[k] = left_start[i];

				counter_time_interval[k] = left_count_interval[i];

				i++;

				k++;

			}

		} else {

			while (j < second_subarray) {

				finish[k] = right_finish[j];

				start[k] = right_start[j];

				counter_time_interval[k] = right_count_interval[j];

				j++;

				k++;

			}

		}

	}

	/***
	 * sorting method of the array
	 * @param finish	finish array
	 * @param lowpoint	low point 
	 * @param highpoint	high point
	 * @param start		start array
	 * @param counter_time_interval	counter time interval 
	 */

	public void sort(int finish[], int lowpoint, int highpoint, int[] start, int[] counter_time_interval) {

		if (lowpoint < highpoint) {

			int midpoint = (lowpoint + highpoint + 1) / 2;

			sort(finish, lowpoint, midpoint - 1, start, counter_time_interval);

			sort(finish, midpoint, highpoint, start, counter_time_interval);

			merge(finish, lowpoint, midpoint, highpoint, start, counter_time_interval);

		}



	}

	/***
	 * Method to find the Maximum length of Schedule
	 * @param n			the number of schedules
	 * @param start		the start time of array 
	 * @param finish 	the finish time of array
	 * @param counter_time_interval	the counter time 
	 * @param time_interval		the time interval
	 */

	public void find_Max_Schedules(int n, int[] start, int[] finish, int[] counter_time_interval,

			int[][] time_interval) {
		//schedule_interval array to maintain the number of schedules per count
		int[] schedule_interval = new int[n];
		//loop that goes on every interval
		for (int i = 0; i < n; i++) {
			//considered the count one
			schedule_interval[i] = 1;
			//loop that checks schedule ahead
			for (int j = 0; j < i; j++) {
				//condition that checks for schedules ahead
				if (finish[j] + time_interval[counter_time_interval[j]][counter_time_interval[i]] <= start[i]) {
					//finding the maximum
					schedule_interval[i] = Math.max(schedule_interval[i], schedule_interval[j] + 1);

				}

			}

		}

		//maximum 
		int maximum=0;
		//loop to find maximum
		for(int i=0;i<n;i++){
		//condition to check maximum
		if(schedule_interval[i]>maximum){
			maximum=schedule_interval[i];
		}
		}
		//prints the maximum
		System.out.println(maximum);

	}

	/***
	 * Main Method
	 * @param args
	 */

	public static void main(String[] args) {
		//Scanner class
		Scanner sc = new Scanner(System.in);
		//Object of the class
		IntervalsBreaks ib = new IntervalsBreaks();
		//the number elements in the array i.e., the number of intervals
		int n = sc.nextInt();
		//start time array
		int[] start = new int[n];
		//finish time array
		int[] finish = new int[n];
		//counter array that maintains the access of time to reach courses array
		int[] counter_time_interval = new int[n];
		//loop for in-take the start and finish time 
		for (int i = 0; i < n; i++) {
			
			start[i] = sc.nextInt();

			finish[i] = sc.nextInt();
	
			counter_time_interval[i] = i;

		}
		//time interval matrix to store values
		int[][] time_interval = new int[n][n];
		//loop that stores value
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				time_interval[i][j] = sc.nextInt();

			}

		}
		//sort the method
		ib.sort(finish, 0, finish.length - 1, start, counter_time_interval);
		//method for the finding the maximum length of the Schedule
		ib.find_Max_Schedules(n, start, finish, counter_time_interval, time_interval);

	}

}
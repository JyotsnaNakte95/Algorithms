import java.util.Scanner;

/***
 * class to find two smallest integers
 * 
 * @author jyotsna
 * 
 */
public class SmallestTwo {
	/**
	 * Main method that finds the s
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// n : numbers given in the input
		int n=sc.nextInt();
		//array that keeps the track of numbers according to n entered
		int a[]= new int[n];
		
		//loop to store the values in an array
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();	
		}
		int Second_Smallest = a[0]<a[1]?a[1]:a[0];
		int First_Smallest = a[0]>a[1]?a[1]:a[0];
		//loop for numbers to check smallest number
		for (int j = 2; j < a.length; j++) {
			//n = a[j];
			//condition if number is smaller than first smallest number
			if (a[j] < First_Smallest) {
				Second_Smallest = First_Smallest;
				First_Smallest = a[j];

			} else {
				//condition if number is smaller than second smallest 
				if (a[j] < Second_Smallest ) {
					Second_Smallest = a[j];

				}
			}

		}
		//printing the values of two smallest integer
		
		System.out.println(First_Smallest);
		System.out.println(Second_Smallest);

	}

}

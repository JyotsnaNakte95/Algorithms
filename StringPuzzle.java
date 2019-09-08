/***
 * class to find minimum steps to change string u into string v
 * 
 * @author jyotsna namdeo nakte jnn2078
 * 
 */

import java.util.Scanner;

public class StringPuzzle {
/**
 * main method
 * @param args
 */
	public static void main(String[] args) {
		//object of class created
		StringPuzzle sp = new StringPuzzle();
		//Scanner class object
		Scanner sc = new Scanner(System.in);
		//counter for while loop till loop goes till end
		int a = 0;
		//to count the number of minimum steps
		int sum = 0;
		//variable used to keep check for substrings with positive number
		int countpositive = 0;
		//variable used to keep check for substrings with positive number
		int countnegative = 0;
		//input string 1
		String u = sc.next();
		//input string 2
		String v = sc.next();
		//converting string 1 to character array
		char string1[] = u.toCharArray();
		//converting string 2 to character array
		char string2[] = v.toCharArray();
		//difference of both strings ascii values stored
		int difference[] = new int[string1.length];
		//loop to store difference of ascii values
		for (int j = 0; j < string1.length; j++) {
			difference[j] = (int) (string2[j]) - (int) (string1[j]);
		}
		//loop that goes till end of the string
		while (a < difference.length - 1) {
			//condition if difference is 0
			if (difference[a] == 0) {
				a++;
				//condition to stop at the end of loop while performing operations
				if (a > difference.length - 1)
					break;
			}
			//conditions if difference is positive
			else if (difference[a] > 0) {
				//including first value in sum
				sum = sum + difference[a];
				//loop that goes till substring positive
				while (difference[a] > 0) {
					if (a + 1 == difference.length - 1) {
						//condition to calculate difference to add in sum 
						if (difference[a] < difference[a + 1]) {
							sum = sum + difference[a + 1] - difference[a];
						}
						a++;
					} else {
						countpositive = difference[a + 1] - difference[a];
						//if countpositive is positive add to sum else ignore
						if (countpositive > 0) {
							sum = sum + countpositive;
						}
					}
					a++;
					//if reach end of loop
					if (a > difference.length - 1)
						break;
				}
				//condition for negative numbers
			} else if (difference[a] < 0) {
				//converting number to positive den adding to sum
				sum = sum + (-difference[a]);
				//if negative number enter loop for negative substrings
				while (difference[a] < 0) {
					//if the next element reaches end of loop
					if (a + 1 == difference.length - 1) {
						if ((-difference[a]) < (-difference[a + 1])) {
							sum = sum + (-difference[a + 1]) - (-difference[a]);
						}
						a++;
						//condition to calculate difference if positive add to sum
					} else {
						countnegative = (-difference[a + 1]) - (-difference[a]);
						if (countnegative > 0) {
							sum = sum + countnegative;
						}
					}
					a++;
					//if it reaches end of loop break
					if (a > difference.length - 1)
						break;
				}
			}
		}
		//prints the value of sum
		System.out.println(sum);
	}
}
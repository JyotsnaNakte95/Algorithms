//import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainParenthesize {
	//number for which array used
	public int arrayNumber = 1;
	//the multiplication number
	public int multiplicationNumber = 2;
	//the paranthesis
	public String optiomalParanthesis = "";
/**
 * Method to print the paranthesis
 * @param start	start of the array
 * @param end	end of the array
 * @param seqArray	sequence array here sequence is stored
 */
	public void getOptimalParanthesis(int start, int end, int[][] seqArray) {
		//condition when start is equal to end the method prints the string formed
		//this condition meets it reaches to the base and prints the answer
		if(start == end) {
			optiomalParanthesis += "A" + arrayNumber + " ";
			multiplicationNumber ++;
			arrayNumber++;
 		} else {
 			//connecting the brackets and multiplication sign
 			optiomalParanthesis += "( ";
 			multiplicationNumber++;
 			getOptimalParanthesis(start, seqArray[start][end], seqArray);
 			optiomalParanthesis += "x ";
 			getOptimalParanthesis(seqArray[start][end]+1, end, seqArray);
 			optiomalParanthesis += ") ";
 		}
	}
/**
 * Method to find the minimum cost of Matrix multiplication
 * @param minimum_cost	solution array
 * @param input			input array
 * @param sequence		array which stores the sequence we found the minimum cost
 */

	public void find_min_cost(int[][] minimum_cost, int[] input, int[][] sequence) {
		//the length of the input array
		int n = input.length;
		//which stores the cost
		int temp;
		//loop for the number of arrays which are to multiply
		for (int d = 1; d < n - 1; d++) {
			for (int L = 1; L < n - d; L++) {
				int R = L + d;
				//base case given minimum value
				minimum_cost[L][R] = Integer.MAX_VALUE;
				for (int k = L; k <= R - 1; k++) {
					//conditin to find minimum trying all the condition
					temp = minimum_cost[L][k] + minimum_cost[k + 1][R] + input[L - 1] * input[k] * input[R];
					//if smaller than assign the minimum to the array index
					if (minimum_cost[L][R] > temp) {
						minimum_cost[L][R] = temp;
						//sequence array that stores the sequence of how it found the minimum cost
						sequence[L][R] = k;
					}
				}
			}
		}
		//print the minimum cost for matrix chain multiplication
		System.out.println(minimum_cost[1][n - 1]);
		//function call for optimal paranthesis printing method
		getOptimalParanthesis(1,n-1,sequence);
		//printing the string
		System.out.println(optiomalParanthesis);
	}
/**
 * Main method that executes first
 * @param args
 */
	public static void main(String[] args) {
		//object of the class created
		MatrixChainParenthesize mmc = new MatrixChainParenthesize();
		//Scanner class for input
		Scanner sc = new Scanner(System.in);
		//number length input
		int n = sc.nextInt();
		//input array created
		int[] input = new int[n + 1];
		//stores value in the input array
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		//System.out.println(Arrays.toString(input));
		//solution array created
		int[][] minimum_cost = new int[n + 1][n + 1];
		//array to store the sequence created
		int[][] sequence = new int[n + 1][n + 1];
		//base case initialized
		for (int i = 1; i < n + 1; i++) {
			minimum_cost[i][i] = 0;
		}
		//function call for finding minimum cost
		mmc.find_min_cost(minimum_cost, input, sequence);
	}

}
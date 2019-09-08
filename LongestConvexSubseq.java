/***
 *class that finds the longest convex subsequence
 * Subsequence is convex if aji−1 + aji+1 ≥ 2aji
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */


import java.util.Scanner;

public class LongestConvexSubseq {
/**
 * Method finds the maximum between two elements
 */
	public static int max(int x, int y){
		//compares between two attributes
		if(x>y){
			return x;
		}
		return y;
	}
	
/**
 * Method that finds the maximum in the solution array 
 */
	public static void find_maximum(int[][] longest_subseq,int n){
		int longest_sequence_length=0;
		//two loop of the array 
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				longest_sequence_length=max(longest_sequence_length, longest_subseq[i][j]);
			}
		}
		longest_sequence_length=longest_sequence_length+2;
		//printing the sequence longest
	System.out.println(longest_sequence_length);
	}
	
	/**
	 * Method that finds the longest convex subsequence
	 */
	public void find_longestConvexSequence(int[] numbers, int[][] longest_subseq, int n ){
        //checking for every element in sequence
        for(int i=1; i<n; i++){
        	//forming the sequence from the prior
            for(int j=0; j<n; j++){
            	//loop checking for that sequence
            	
                for(int k=0; k<j; k++){
                	
                	
                    //condition check of the convex subsequence
                			if(numbers[i]+numbers[k]>= 2*numbers[j]){
                    	longest_subseq[i][j] = max(longest_subseq[j][k]+ 1 , longest_subseq[i][j]);
                    }
                }
                
            }
        }
        find_maximum(longest_subseq, n);
    }

    /**
     * Main method where the program starts executing
     */
    public static void main(String args[]){
    	//Scanner class
        Scanner sc = new Scanner(System.in);
        //the number of elements
        int n = sc.nextInt();
        //the input of the numbers array
        int[] numbers = new int[n];
        //loop that takes the input
        for(int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }
        int[][] longest_subseq = new int[n][n];
        //object created of the class
        LongestConvexSubseq lcs = new LongestConvexSubseq();
        //base case
        longest_subseq[0][0] = 1;
        //calling the method
        lcs.find_longestConvexSequence(numbers,longest_subseq,n );
    }
}

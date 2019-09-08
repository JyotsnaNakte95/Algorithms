/***
 *class that finds the longest increasing subsequence  
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */

import java.util.Scanner;
public class LongestIncreasingSubseqDP {
/**
 * 
 * @param numbers array of numbers
 * @param count   array of count array
 * @param n		  number of elements in the array
 */
public void finding_max(int[] numbers,int[] count, int n){
	 //maximum length stored variable
	 int max=0;
	 //loop that finds for every element
	 for(int i =1;i< n;i++){
		 //loop that finds for the longest sequence
		for(int j=0;j<i;j++){
			//condition that checks
			if(numbers[i]>numbers[j] && count[i]<count[j]+1){
				count[i]=count[j]+1;
			}
		}
	}
	//loop to find maximum
	for(int i=0;i<n;i++){
		if(count[i]>max){
			max=count[i];
		}
	}
	//prints maximum
	System.out.println(max);
	}
/**
 * Main Method
 * @param args
 */
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		//Scanner Class
		Scanner sc = new Scanner(System.in);
		//number of elements
		int n = sc.nextInt();
		//numbers array
		int[] numbers = new int[n];
		//number of count
		int[] count = new int[n];
		//setting to 1
		for(int k=0;k<n;k++){
			count[k]=1;
		}
		//input in the array
		for(int i=0;i<n;i++){
			numbers[i]=sc.nextInt();
		}
		//object of the array
		LongestIncreasingSubseqDP ld = new LongestIncreasingSubseqDP();
		//method to find max 
		ld.finding_max(numbers,count,n);
		long time = System.currentTimeMillis() - start;
		System.out.println("Time taken to execute:" +time);
	}
}

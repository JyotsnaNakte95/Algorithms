/***
 *class that finds the sum of all the Increasing Subsequences in array
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */
import java.util.Scanner;
public class LongestIncreasingSubseqCount {
	/**
	 * Method of finding maximum length of the longest Increasing Subsequences
	 * @param numbers  Array of the numbers
	 * @param count    Count array that maintains the array
	 * @param n			N is the length of the Array
	 */
	public void finding_count(int[] numbers,long[] count, int n){
		//long variable of the sum 
		 long sum=0;
		 //loop that checks for every element
		 for(int i =1;i< n;i++){
			 //loop that checks further increasing sequence of that current element
			for(int j=0;j<i;j++){
				//condition if number is greater that current 
				if(numbers[i]>numbers[j]){
					//that maintains the count 
					count[i]=count[i]+count[j];	
					//condition if the number is greater than 1000000
					if(count[i]>1000000){
						count[i]=count[i]%1000000;
					}

				}
				
			}
		}
		 //loop that finds the sum of the increasing sequences
		for(int i=0;i<n;i++){
			sum=(long)sum+count[i];
			//if(sum>1000000){
				//sum=sum%1000000;
			//}
			//System.out.println(sum);
			}
		//for empty array
		sum=(long)sum+1;
		sum=(long)sum%1000000;
		//prints the sum
		System.out.println(sum);
		}
		/**
		 * Main Method
		 * @param args
		 */

		public static void main(String[] args){
			//long start = System.currentTimeMillis();

			Scanner sc = new Scanner(System.in);
			//number of the elements in the array
			int n = sc.nextInt();
			//array for the numbers
			int[] numbers = new int[n];
			//array that maintains count
			long[] count = new long[n];
			//loop that keeps count 1
			for(int k=0;k<n;k++){
				count[k]=1;
			}
			//loop that stores elements 
			for(int i=0;i<n;i++){
				numbers[i]=sc.nextInt();
			}
			//object of the class
			LongestIncreasingSubseqCount lc = new LongestIncreasingSubseqCount();
			//method that finds count
			lc.finding_count(numbers,count,n);
			//long time = System.currentTimeMillis() - start;
			//System.out.println("Time taken to execute:" +time);
		}

}

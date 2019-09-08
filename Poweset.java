import java.util.Arrays;
import java.util.Scanner;


public class Poweset {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] numbers = new int[n];
		for(int i=0;i<n;i++){
			numbers[i]=sc.nextInt();			
		}
		int[][] number_pairs = new int[n+1][n+1];
		for(int i=0;i<1;i++){
			for(int j=0;j<n;j++){
				number_pairs[i][j]=numbers[j];
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<1;j++){
				number_pairs[i][j]=numbers[i];
			}
		}
		/*for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if()
				number_pairs[i][j]=0;
			}
		}*/
	
		System.out.println(Arrays.toString(number_pairs));
		
		Poweset p = new Poweset();
		
	}
}

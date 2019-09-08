import java.util.Arrays;
import java.util.Scanner;

public class MatrixMultiplicationCost {
	public void find_min_cost(int[][] minimum_cost,int[] input, int[][] sequence){
		int n=input.length;
		int temp;
		for(int d=1;d<n-1;d++){
			for(int L=1;L<n-d;L++){
				int R=L+d;
				minimum_cost[L][R]=Integer.MAX_VALUE;
				for(int k=L;k<=R-1;k++){
					temp=minimum_cost[L][k]+minimum_cost[k+1][R]+input[L-1]*input[k]*input[R];
					if (minimum_cost[L][R] > temp){
					 minimum_cost[L][R] = temp;
					 sequence[L][R]=k;
					}
				}
			}
		}
		
		System.out.println(minimum_cost[1][n-1]);

for(int i = 0; i<n; i++)
{
    for(int j = 0; j<n; j++)
    {
        System.out.print(minimum_cost[i][j]+" ");
    }
    System.out.println();
}

for(int i = 0; i<n; i++)
{
    for(int j = 0; j<n; j++)
    {
        System.out.print(sequence[i][j]);
    }
    System.out.println();
}
	}
	
	public static void main(String[] args){
		MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] input = new int[n+1];
		for(int i=0;i<input.length;i++){
			input[i]=sc.nextInt();
		}
		System.out.println(Arrays.toString(input));
		int[][] minimum_cost= new int[n+1][n+1];
		int[][] sequence= new int[n+1][n+1];
		for(int i=1;i<n+1;i++){
			minimum_cost[i][i]=0;
		}
		mmc.find_min_cost(minimum_cost,input, sequence); 		
	}
	
}
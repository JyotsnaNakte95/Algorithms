import java.util.Arrays;
import java.util.Scanner;


public class MinimumCost {

	public void Minimum_Cost(int n,int C,int[] cost,int[] weight,int[][] min_weight) 
{ 


// now check for each weight one by one and 
// fill the matrix according to the condition 
for (int i = 1; i <= n; i++) 
{ 
for (int j = 1; j <= C; j++) 
{ 
// wt[i-1]>j means capacity of bag is 
// less then weight of item 
if (cost[i-1] > j) 
min_weight[i][j] = min_weight[i-1][j]; 

// here we check we get minimum cost  
// either by including it or excluding 
// it 
else
min_weight[i][j] = Math.min(min_weight[i-1][j], 
 min_weight[i][j-cost[i-1]] +  
             weight[i-1]); 
} 
} 

// exactly weight W can not be made by  
// given weights 
System.out.println(min_weight[n][C]);
} 
	

/* Driver program to test above function */

public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
	int C=sc.nextInt();
	int[] weight = new int[n];
	int[] cost=new int[n];
	for(int i=0;i<=n;i++){
		weight[i]=sc.nextInt();
		cost[i]=sc.nextInt();
		
	}
	System.out.println(Arrays.toString(weight));
	System.out.println(Arrays.toString(cost));
	int[][] min_weight =new int[n+1][C+1];
	
	int v=n+1;
	int k=C+1;
	for(int i=0;i<k;i++){
		min_weight[0][i]=Integer.MAX_VALUE;
		//min_weight[0][i]=1000;
	}	
	for(int j=1;j<v;j++){
		min_weight[j][0]=0;
	}
	
	//System.out.println(Arrays.toString(min_weight));
	/* 
	for(int i=1;i<v;i++){
		 for(int j=1;j<k;j++){
			 min_weight[i][j]=Integer.MAX_VALUE;
		 }
	 }
	 
	 /*
	 for(int i=1;i<v;i++){
		 for(int j=1;j<k;j++){
			 System.out.println(min_weight[i][j]);
		 }
	 }
	 */
	MinimumCost mc = new MinimumCost();
	mc.Minimum_Cost(n,C,cost,weight, min_weight);
	//mwk.knapsack(n, C, cost, weight, min_weight);
	}

} 
	


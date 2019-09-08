import java.util.Scanner;


public class WeightedByDiffInversions {
	
	public int merge(int ar[], int lowpoint, int midpoint, int highpoint) {
		int inversion_count =0;
		int weighted_inversion=0;
		int first_subarray = midpoint - lowpoint, second_subarray = highpoint - midpoint + 1;
		int left[] = new int[first_subarray];
		int right1[] = new int[second_subarray];
		int right2[] = new int[second_subarray];
		
		int k = lowpoint, i = 0, j = 0;

		for (int m = 0; m < first_subarray; m++) {
			left[m] = ar[lowpoint + m];
		}
		for (int n = 0; n < second_subarray; n++) {
			right1[n] = ar[midpoint + n];
			right2[n] = ar[midpoint + n];
		}

		while (i < first_subarray && j < second_subarray) {
			if (left[i] <= right1[j]) {
				ar[k] = left[i];
				i++;
			} else {
				for(int z=0;z<right2.length;z++){
					if(left[i]>right2[z]){
					int diff=Math.abs(left[i]-right2[z]);
					weighted_inversion=weighted_inversion+diff;
					}
					System.out.println("In merging"+weighted_inversion);
					}
				ar[k] = right1[j];
				j++;
				inversion_count=inversion_count +( left.length-i);
				
				//System.out.println("Merging part  "+inversion_count);
			}
			k++;
			
		}
		if (i < first_subarray) {
			while (i < first_subarray) {
				ar[k] = left[i];
				i++;
				k++;
			}
		} else {
			while (j < second_subarray) {
				ar[k] = right1[j];
				j++;
				k++;
			}
		}
		return  weighted_inversion;
	}

	public int counting_weighted_inversion_sum(int ar[], int lowpoint, int highpoint) {
		int inversion_count=0;
		int weighted_inversion=0;
		//System.out.println("start "+inversion_count);
		if (lowpoint < highpoint) {
			int midpoint = (lowpoint + highpoint + 1) / 2;
			//inversion_count=counting_weighted_inversion_sum(ar, lowpoint, midpoint - 1);
			weighted_inversion=counting_weighted_inversion_sum(ar, lowpoint, midpoint - 1);
			System.out.println("1 phase "+weighted_inversion);
			//inversion_count=inversion_count + counting_weighted_inversion_sum(ar, midpoint, highpoint);
			weighted_inversion=weighted_inversion+counting_weighted_inversion_sum(ar, midpoint, highpoint);
			System.out.println("2 phase "+weighted_inversion);
			//inversion_count=inversion_count+merge(ar, lowpoint, midpoint, highpoint);
			weighted_inversion=weighted_inversion+merge(ar, lowpoint, midpoint, highpoint);
			System.out.println("3 phase "+weighted_inversion);
		}
		return weighted_inversion;
	}


public static void main(String[] args){
	WeightedByDiffInversions wd = new WeightedByDiffInversions();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the n:");
	int n=sc.nextInt();
	int numbers[] = new int[n];
	for(int i=0;i<n;i++){
		numbers[i]=sc.nextInt();
	}
	int x = wd.counting_weighted_inversion_sum(numbers, 0,numbers.length-1);
	System.out.println(x);
	
}
}

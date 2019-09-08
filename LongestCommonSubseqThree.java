
/***
 *class that finds the longest common sequence between three sequences
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */

import java.util.Arrays;
import java.util.Scanner;
public class LongestCommonSubseqThree {
/**
 * 	
 * @param first_seq		Array of the first sequence
 * @param second_seq	Array of the second sequence
 * @param third_seq		Array of the third sequence
 * @param common_seq	Solution array that stores the common sequence
 * @param first			length of the first sequence array
 * @param second		length of the second sequence array
 * @param third			length of the third sequence array
 */

	public void find_common_subsequence(int[] first_seq, int[] second_seq, int[] third_seq, int[][][]common_seq,
			int first, int second, int third){
		//loop for the length of third sequence
		for (int i=0; i<=third; i++)

        {
			//loop for the second sequence
            for (int j=0; j<=second; j++)

            {
            	//loop for the first sequence
                for (int k=0; k<=first; k++)

                {
                	//condition base for the rows, columns is kept zero
                    if (i == 0 || j == 0||k==0)

                        common_seq[i][j][k] = 0;
                    //if equal of the sequence than update the length in solution array
                    else if (first_seq[k - 1] == second_seq[j - 1]   && first_seq[k - 1]==third_seq[i - 1]) {

                        common_seq[i][j][k] = common_seq[i-1][j-1][k-1] + 1;

                    }

                    else
                    	//maximum length of the three sequence similar stored
                        common_seq[i][j][k] = Math.max(Math.max(common_seq[i-1][j][k],

                                             common_seq[i][j-1][k]),

                                         common_seq[i][j][k-1]);

                }

            }

        }



		int len_a = first_seq.length, len_b = second_seq.length, len_c = third_seq.length;
		//int len_a = first, len_b = second, len_c = third;
		//the array that stores the subsequence for reconstructing the solution
		int[] subsequence_array = new int[common_seq[third][second][first]];
		int index = common_seq[third][second][first] - 1;
		//loop till the sequence length of arrays is greater than zero
		while(len_a>0 && len_b>0 && len_c>0) {
			//if equal with third sequence
			if(common_seq[len_c][len_b][len_a] == common_seq[len_c - 1][len_b][len_a]) {

				len_c--;
				//if equal with second sequence
			} else if(common_seq[len_c][len_b][len_a] == common_seq[len_c][len_b - 1][len_a]) {

				len_b--;
				//if equal with first sequence
			} else if(common_seq[len_c][len_b][len_a] == common_seq[len_c][len_b][len_a - 1]) {

				len_a--;

			} else {

				//System.out.println(third_seq[len_c - 1]);
				//store in the subsequence array
				subsequence_array[index] = third_seq[len_c - 1];

				len_a--; len_b--; len_c--; index--;

			}

		}

        //System.out.println(Arrays.toString(subsequence_array));


		//printing the length of common subsequence
        System.out.println(common_seq[third][second][first]);
        //printing the subsequence
        for(int i=0;i<subsequence_array.length;i++){
        	System.out.print(subsequence_array[i] +" ");
        	
        }

	}
	

/**
 * Main method where the program works	
 * @param args
 */

public static void main(String[] args){
		//object of the class
		LongestCommonSubseqThree Lcst = new LongestCommonSubseqThree();
		//Scanner class
		Scanner sc = new Scanner(System.in);
		//first length of array
		int  first=sc.nextInt();
		//second length of array
		int second=sc.nextInt();
		//third length of the array
		int third=sc.nextInt();
		//first sequence array input creaated
		int[] first_seq = new int[first];
		//second sequence array input created
		int[] second_seq = new int[second];
		//third sequence array input created
		int[] third_seq = new int[third];
		//input taken from scanner
		for(int i=0;i<first_seq.length;i++){

			first_seq[i]=sc.nextInt();

		}

		for(int i=0;i<second_seq.length;i++){

			second_seq[i]=sc.nextInt();

		}

		for(int i=0;i<third_seq.length;i++){

			third_seq[i]=sc.nextInt();

		}

		//solution array
		int[][][] common_seq= new int[third+1][second+1][first+1];
		//function call
		Lcst.find_common_subsequence(first_seq,second_seq,third_seq,common_seq,first,second,third);

	}

}




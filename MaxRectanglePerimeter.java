/***
 * class finds the Maximum Perimeter rectangle in the given number of points
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author Manali Chakraborty
 */

import java.util.Arrays;
import java.util.Scanner;

public class MaxRectanglePerimeter {
	/***
	 * Method that calculates Max Rectangle Perimeter in given points
	 * @param height	height found of points
	 * @param width		width found of points
	 * @param length	length of the height array
	 */

	public static void calculateMaxPerimeter(int[] height, int[] width, int length) {
		//Variable that keeps track of maximum perimeter
		int max_perimeter = 0;
		//stack index variable that works as top pointer
		int stackIndex = 0;
		//heightStack variable that works like a stack in array going through heights of points
		int[] heightStack = new int[length];
		//widthStack variable that works like a stack in array going through widths of points
		int[] widthStack = new int[length];
		//keeps track previous width
		int previousWidth = 0;
		//keeps track of index value till it checks all the values
		int index = 0;
		//loop till it checks for all elements in height stack
		while(index < height.length) {
			//condition if index zero
			if (index == 0) {
				//previous width gets updated with first
				previousWidth += width[index];
				//height stack keeps track of elements found perimeter that updates index
				heightStack[stackIndex] = index;
				//width stack keeps track of elements found perimeter that updates index
				widthStack[stackIndex] = width[index];
				//if value inserted in stack increase count
				stackIndex++;
				//increase index value
				index ++;

			} else {
				//condition if stack index is 0 or if height element one lesser is greater than current 
				if (stackIndex == 0 || height[heightStack[stackIndex - 1]] <= height[index]) {
					//we update previous width
					previousWidth += width[index];
					//update the width Stack
					widthStack[stackIndex] = previousWidth;
					//update the height stack
					heightStack[stackIndex] = index;
					//increase stack index count
					stackIndex ++;
					//increase index count
					index ++;

				} else {
					//condition if stack index is 1 i.e. one element in stack
					if (stackIndex == 1) {
						//it finds the maximum perimeter and compares with max perimeter to update accordingly
						max_perimeter = Math.max(max_perimeter, 2 * (height[heightStack[stackIndex - 1]] + previousWidth));

					} else {
						//if more elements in stack it finds for all and accordingly checks and updates perimeter keeping track of widths
						max_perimeter = Math.max(

							max_perimeter,

							2 * (height[heightStack[stackIndex -1 ]] + previousWidth - widthStack[stackIndex - 2]));

					}

					stackIndex--;

				}

			}

		}

		//System.out.println("MAX + " + max_perimeter);
		//condition till stack is not empty
		while (stackIndex != 0) {

			//System.out.println(Arrays.toString(heightStack) + " " + Arrays.toString(widthStack) + " " + stackIndex + " " + previousWidth);
			//condition if stack Index is 1
			if (stackIndex == 1) {
				//find maximum perimeter
				max_perimeter = Math.max(max_perimeter, 2 * (height[heightStack[stackIndex - 1]] + previousWidth));

			} else {
				//if more elements in stack it finds for all and accordingly checks and updates perimeter keeping track of widths
				max_perimeter = Math.max(

					max_perimeter,

					2 * (height[heightStack[stackIndex -1 ]] + previousWidth - widthStack[stackIndex - 2]));

			}

			stackIndex--;

		}
		//prints the maximum perimeter.
		System.out.println(max_perimeter);

	}

	/***
	 * Main Method that call all the methods
	 * @param args
	 */

	public static void main(String[] args) {
		//Scanner class takes input from the command line
		Scanner sc = new Scanner(System.in);
		//variable that takes number of points as input
		int n = sc.nextInt();
		//arrays that store length, breadth i.e. x-y co-ordinates from user
		int length_y[] = new int[n], breadth_x[] = new int[n];
		//arrays that store height, width of the points
		int[] width = new int[(n / 2) - 1], height = new int[(n / 2) - 1];
		//variables to keep counter while computing height, width
		int counter_height = 0, counter_width = 0;
		//loop that takes input from user
		for (int i = 0; i < n; i++) {
			breadth_x[i] = sc.nextInt();
			length_y[i] = sc.nextInt();
		}
		//loop that counts the height and width of points
		for (int j = 1; j < length_y.length - 1; j = j + 2) {
			height[counter_height] = length_y[j];
			counter_height++;
			width[counter_width] = Math.abs(breadth_x[j] - breadth_x[j + 1]);
			counter_width++;
		}
		//function call to calculate Perimeter
		calculateMaxPerimeter(height, width, width.length);
		sc.close();

	}

}
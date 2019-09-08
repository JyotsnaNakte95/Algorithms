/***
 *class that finds the minimum length for police cars to travel to increase the cost of donut 
 * 
 * @author jyotsna namdeo nakte jnn2078
 * @author manali chakraborathy
 * 
 */

import java.util.Scanner;

public class Donut {
	/**
	 * 
	 * @param x_best	the best x-cordinate
	 * @param y_best	the best y-co-ordinate
	 * @param x_cord	the x-cordinates array
	 * @param y_cord	the y-cordinates array
	 */
	public void finding_best_distance(int x_best,int y_best,int[] x_cord,int[] y_cord){
		//variable best minimum distance
		int best_dist=0;
		//loop that finds the minimum best distance
		for(int i=0;i<x_cord.length;i++){
			best_dist=best_dist+(Math.abs(x_best-x_cord[i])+Math.abs(y_best-y_cord[i]));
		}
		//prints the best minimum distance
		System.out.println(best_dist);
		
	}
	/**
	 * Main Method
	 * @param args
	 */
public static void main(String[] args){
	//object of the class
	Donut d = new Donut();
	//Scanner class
	Scanner sc= new Scanner(System.in);
	//number of coordinates
	int n = sc.nextInt();
	//the x cordinate array
	int[] x_cord= new int[n];
	//the y cordinate array
	int[] y_cord = new int[n];
	//loop that stores x,y cordinates in array
	for(int i=0;i<n;i++){
		x_cord[i]=sc.nextInt();
		y_cord[i]=sc.nextInt();
	}
	//best x,y co-ordinates for minimum distance
	int x_best,y_best;
	//sum of x and y
	int sum_x = 0,sum_y=0;
	//loop that finds sum of x
	for(int i=0;i<n;i++){
		sum_x= sum_x+x_cord[i];
	}
	//loop that finds sum of y 
	for(int i=0;i<n;i++){
		sum_y= sum_y+y_cord[i];
	}
	//finds the centroid that finds the x,y co-ordinate
	x_best=sum_x/n;
	y_best=sum_y/n;
	//method finds the minimum best distance
	d.finding_best_distance(x_best,y_best,x_cord,y_cord);
	
}
	
}

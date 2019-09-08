
import java.util.Scanner;
/***
 * 
 * @author jyotsna
 * class to find prime numbers
 */
public class Find_Primes {
/**
 * method that displays prime numbers
 * 
 * @param number
 */
public void Display_Primes(int number){
	if(number<2){
		System.out.println("Number has no prime numbers in range");
	}
	/*
	 * loop that goes from 2 to range to find 
	 */
	for(int i=2;i<=number;i++){
		int count = 0;
	/*
	 * loop that finds factors	
	 */
		for(int j=2;j<=i;j++){
			if(i%j==0){
				count++;
			}
		}
		/**
		 * condition that satisfies the condition of number being prime
		 */
			if(count==1){
				System.out.println(i);
			}
		}
	
}
/***
 * Main method of the program that calls the method Find_Primes
 * and displays the prime numbers in that range.
 * @param args
 */
public static void main(String[]args){
	Scanner sc = new Scanner(System.in);
	//System.out.println("Enter number to find primes list:");
	int number=Integer.parseInt(args[0]);
	Find_Primes fp = new Find_Primes();
	fp.Display_Primes(number);
	
}
}

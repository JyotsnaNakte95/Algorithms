import java.util.Scanner;

/***
 * 
 * @author jyotsna class to find prime numbers
 */
public class Primes {
	/**
	 * method that displays prime numbers
	 * 
	 * @param number
	 */
	public void Display_Primes(int number) {
		

		// loop that goes from 2 to range to find

		for (int i = 2; i <= number; i++) {
			int count = 0;

			// loop that finds factors

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					count++;
					break;
				}
			}

			// condition that satisfies the condition of number being prime

			if (count == 0) {
				System.out.println(i);
			}
		}

	}

	/***
	 * Main method of the program that calls the method Find_Primes and displays
	 * the prime numbers in that range.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number= sc.nextInt();
		Primes p = new Primes();
		p.Display_Primes(number);

	}
}

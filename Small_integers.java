import java.util.Scanner;
/***
 * class to find two smallest integers
 * @author jyotsna 
 *
 */
public class Small_integers {
/**
 * Main method that finds the s
 * @param args
 */
		
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int n;
		int b=0 ;
		int a= Integer.parseInt(args[0]);
		
		
		for(int i=0;i<args.length;i++){
			n=Integer.parseInt(args[i]);
			if(n<a){
				b=a;
				a=n;
				
			}
			}
		System.out.println(a);
		System.out.println(b);
		
	}

}

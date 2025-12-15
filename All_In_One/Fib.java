package cdac;
import java.util.Scanner;
public class Fib {

	    // Recursive function to get nth Fibonacci number
	    static int fib(int n) {
	        if (n == 0) return 0;
	        if (n == 1) return 1;
	        return fib(n - 1) + fib(n - 2);
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter how many Fibonacci numbers to print: ");
	        int n = sc.nextInt();

	        for (int i = 0; i < n; i++) {
	            System.out.print(fib(i) + " ");
	        }

	        sc.close();
	    }
	}

package dsa;

public class Factorial {
	public static void main(String[] a) {
		System.out.println(new Factorial().factorialByIteration(7));		
		System.out.println(new Factorial().factorialByRecursion(7));
	}
	int factorialByIteration(int n) {
		int temp = 1;
		for(int i=n; i>0; i--) {
			temp =  temp * i;
		}
		return temp;
	}
	int factorialByRecursion(int n) {
		if(n==1) 
			return 1;
		return n * factorialByRecursion(n-1);
	}
}
package cdac;

public class UnderstandingRecursion {
	public static void main(String[] a) {
		UnderstandingRecursion usr = new UnderstandingRecursion();	
		usr.m2();
	}
	void m1() {
		// Termination condition
		System.out.println("m1 called");
		
		
	}
	void m2() {
		System.out.println("m2 called");
		m1();
	}
}
package dsa;
public class FibonacciByTwoApproaches {
	
	// Memoization using an array
	static  long[] arr = new long[45];

	public static void main(String[] a) {

		//System.out.println("number of milliseconds in a day: "+(24L*60*60*1000*1000));		
		for(int i=0; i<FibonacciByTwoApproaches.arr.length; i++) {
			arr[i] = -1;
		}
		
		/*long timebeforecall = System.nanoTime();
		System.out.println(new FibonacciByTwoApproaches().fibonacciByRecursion(45));  // 1 1 2 3 5 8 13 21 34		
		long timeaftercall = System.nanoTime();
		System.out.println("time taken: "+(timeaftercall-timebeforecall));*/

		long timebeforecall = System.nanoTime();
		System.out.println(new FibonacciByTwoApproaches().fibonacciByMemoization(45));  // 1 1 2 3 5 8 13 21 34		
		long timeaftercall = System.nanoTime();
		System.out.println("time taken: "+(timeaftercall-timebeforecall));

	}  
	long fibonacciByRecursion(long n) {
		if(n==0 || n==1) {
			return n;
		}
		return fibonacciByRecursion(n-1)+fibonacciByRecursion(n-2);
	}

	long fibonacciByMemoization(long n) {
		long fib = 0;
		if(n==0 || n==1) {
			return n;
		} else  if(arr[(int)n]!=-1) {
			return arr[(int)n];  // avoiding the execution of the complete 
// recursion tree under the nth fibonacci call
		} else {
			fib = fibonacciByMemoization(n-1) + fibonacciByMemoization(n-2);
			arr[(int)n] = fib;
			return fib;
		}
	}
}
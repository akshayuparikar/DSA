package dsa;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = {2, 5, 16, 12, 15}; 
		System.out.println("Given Array:");
		for(int itr : a)
		{
			System.out.print(itr + " ");
		}
	   	
		bubbleSort(a);
		 System.out.println("After iteration happen:");

		for(int itr : a) {
			System.out.print(itr + " ");
		}
	} 
	private static void bubbleSort(int[] a) {
		int size = a.length;
		int i,j,temp, counter=0;
		boolean swap = false;
		for(i=0; i<size-1; i++)
		{
			swap = false;
			for(j=0; j<size-1; j++) 
			{
				counter++;
				if(a[j]>a[j+1]) {
					swap = true;
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]= temp;
				}
			}
			if(swap) {
				System.out.println("\nswap happened. \nIterations done count: "+counter);
				break;
			} else {
				System.out.println("\nswap DIDN'T happen because array is already sorted. Iterations: "+counter);
				break;
			}
			
		}
	}
}

package dsa;

public class Linearsearchex {

	public static void main(String[] args) 
	{
		int []a= {34,2,4,3,13,42,53};
		int target=34;
		
		System.out.println("Given array: ");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	
		for(int i=0;i<a.length;i++) {
			if(a[i]==target) {
				System.out.println("\nSearched element of array is found: "+target+" At index: "+i);
			}
		}
	}
}

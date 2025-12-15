package dsa;

public class BinarySearchUsingIteration {

	public static void main(String[] args) {
		int[] arr = {4, 9, 11, 16, 19, 21, 25, 28};
		System.out.println(new BinarySearchUsingIteration().binarySearch(20, arr));
	}

	int binarySearch(int temp, int c[]) {
		int low=0, high=c.length-1, mid=0;
		// the iteration ends when the low and high meet each or cross each other
		while(low<=high) {
			mid = (low+high)/2; // compute the mid of the array
			if(temp > c[mid]) {  // if true, implies that the element searched in the RIGHT half
				low = mid+1;
			} else if(temp < c[mid]) { // if true, implies that the element searched in the LEFT half
				high = mid-1;
			} else if(temp == c[mid]) { // if true, implies that the element searched in present at the MID index location
				return mid;
			} else {

			}
		}
		return -1; // implies that the element searched is NOT PRESENT in the array
	}
	
}

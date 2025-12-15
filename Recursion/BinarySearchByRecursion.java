package cdac;

public class BinarySearchByRecursion {
	
	public static void main(String[] args) {
		int[] arr = {4, 9, 11, 16, 19, 21, 25, 28};
		System.out.println(new BinarySearchByRecursion().binarySearch(arr, 0, arr.length-1, 25));
	}
	
	int binarySearch(int arr[], int low, int high, int temp) {
		// termination condition: when the low becomes equal to or more than high
		if(low>=high) {
			return -1;
		}
		int mid = (low+high)/2;
		if(temp == arr[mid]) { // if the element searched for is present at MID or not
			return mid;
		}
		if(temp < arr[mid]) {  // if true implies that the element searched for may be present in LEFT half
			return binarySearch(arr, low, mid-1, temp);
		}
		// if true implies that the element searched for may be present in RIGHT half
		return binarySearch(arr, mid+1, high, temp); 
	}
}

public class HeapSort {
	
	// Heapification
	void heapify(int arr[], int n, int i) {
		int max = i; // assume the max element is at the ith location
		int leftchild = 2*i+1;
		int rightchild = 2*i+2;
		
		if(leftchild < n && arr[leftchild] > arr[max]) {
			max = leftchild;
		}
		if(rightchild < n && arr[rightchild] > arr[max]) {
			max = rightchild;
		}
		if(max != i) {
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			// breakpoint 6
			heapify(arr, n, max);
		}
	}
	
	public void constructHeap(int arr[]) {
		int n = arr.length;
		// breakpoint 1
		for(int i=n/2; i>=0; i--) {
			// breakpoint 2
			heapify(arr, n, i);
		}
		// breakpoint 3
		for(int i=n-1; i>0; i--) {
			
			// swapping of the root (max element) with the last element of the heap
			// where arr[0] is the root (max element) and ith location is the last element
//			System.out.println(arr[0]+", "+arr[i]);
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			// the max is now considered as sorted and its location is fixed in the array
			// we now perform heapification of the remaining elements
			// breakpoint 4
			heapify(arr, i, 0);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {25, 57, 48, 37, 12, 92, 86, 33};
		new HeapSort().constructHeap(arr);
		for(int i : arr) {
			System.out.print(i+"  ");
		}
	}

}

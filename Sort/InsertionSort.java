package com.example.datastructure;

public class InsertionSort {
	
	
	public static void main(String[] args) {
		int a[] = {24,56,2,70,10,5};
		
		insertionSort(a);
		
		for(int itr : a) {
			System.out.print(itr+" ");
		}
	}

	private static void insertionSort(int[] a) {
		int size=a.length;
		
		for(int i=0; i<size;i++) {
			int temp=a[i];
			int j=i-1;
			while(j>=0 && a[j] > temp) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
		
	}

}

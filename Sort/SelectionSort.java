package com.example.datastructure;

public class SelectionSort {
		
	
	public static void main(String[] args) {
		int a[] = {40,20,60,10,2,90};
		
		
		selectionSort(a);
		
		for(int itr : a) {
			System.out.println(itr+" ");
		}
	}

	private static void selectionSort(int[] a) {
		int temp=0;
		int size=a.length;
		
		for(int i=0;i<size-1;i++) {
			
			int min=i;
			
			for(int j= i+1; j<size-1; j++) {
				if(a[min]>a[j]) {
					min=j;
				}
				
				temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	
	}
}

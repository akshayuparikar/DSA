package com.example.datastructure;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] a = {10,5,2,15,12};
		
		
		bubbleSort(a);
		
		for(int itr : a) {
			System.out.print(itr+ " ");
		}
	}

	private static void bubbleSort(int[] a) {
		int size = a.length;
		
		int i, j, t;
		for(i=0; i<=size-1;i++) {
			for(j=0; j<size-1;j++) {
				
				if(a[j]>a[j+1]) {
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
			}
		}
	}
}

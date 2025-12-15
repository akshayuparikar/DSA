package dsa;

public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {9, 5, 3, 2, 4};

        System.out.println("Given Array:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        selectionSort(a);

        System.out.println("\nAfter Selection sorted:");
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
    }

    private static void selectionSort(int[] a) {
    	int temp;
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            // Swap
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

}

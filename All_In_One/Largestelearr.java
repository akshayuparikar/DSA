package dsa;

public class Largestelearr {

    public static void main(String[] args) {

        int[] a = {2, 5, 6, 9, 1, 5, 3, 6};
        int large = a[0];

        System.out.println("Provided Array by user:");
        for (int num : a) 
        {
            System.out.print(num + " ");
        }
        for (int i = 1; i < a.length; i++) 
        {
            if (a[i] > large) 
                large = a[i];
            
        }
        System.out.println("\nLargest element of given array: " + large);
    }
}

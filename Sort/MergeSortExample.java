package dsa;

public class MergeSortExample 
{
    public static void main(String[] args) 
    {
        int[] a = {5,2,9,1,6,3,2};

        System.out.println("Given Array:");
        for (int num : a) 
        {
            System.out.print(num + " ");
        }
    
        //call methods
        mergeSort(a, 0, a.length - 1);

        System.out.println("\nSorted Array:");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] a, int left, int right)
    {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort left half
            mergeSort(a, left, mid);
            // Sort right half
            mergeSort(a, mid + 1, right);
            // Merge both halves
            merge(a, left, mid, right);
        }
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = a[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = a[mid + 1 + j];

        // Merge temp arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) 
            {
                a[k] = L[i];
                i++;
            } 
            else 
            {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

}

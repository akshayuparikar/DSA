package cdac;

import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = n * (n + 1) / 2;
        int actual = 0;

        for (int i = 0; i < n - 1; i++) 
        	actual += sc.nextInt();

        System.out.println(sum - actual);
    }
}
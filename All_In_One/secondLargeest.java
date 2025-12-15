package cdac;

import java.util.Scanner;

public class secondLargeest {

    // Function to check if a number is prime
    static boolean isprime(int n) {
        if (n <= 1) return false; // 0 and 1 are not prime

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isprime(n)) {
            System.out.println(n + " is Prime");
        } else {
            System.out.println(n + " is Not Prime");
        }

        sc.close();
    }
}

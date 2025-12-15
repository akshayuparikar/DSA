package cdac;

import java.util.Scanner;

public class PalindromeCheck {
    static boolean isPalindrome(String s) {
        // Convert string to character array
        char[] arr = s.toCharArray();

        // Find length manually (no length())
        int len = 0;
        for (char c : arr) {
            len++;
        }

        int i = 0, j = len - 1;
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Palindrome ✅");
        } else {
            System.out.println("Not a palindrome ❌");
        }

        sc.close();
    }
}


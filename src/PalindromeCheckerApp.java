import java.util.Scanner;

public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask user for input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String original = scanner.nextLine();

        String reversed = "";

        // Reverse the string using for loop
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        // Compare original and reversed string
        if (original.equals(reversed)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
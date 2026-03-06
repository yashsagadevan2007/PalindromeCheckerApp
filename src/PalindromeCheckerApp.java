import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {

    // UC3: Reverse String Method
    public static boolean reverseStringMethod(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return input.equals(reversed);
    }

    // UC4: Two-Pointer Char Array Method
    public static boolean twoPointerMethod(String input) {
        char[] chars = input.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // UC5: Stack Method
    public static boolean stackMethod(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) stack.push(ch);
        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }

    // UC7: Deque Method
    public static boolean dequeMethod(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : input.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // UC9: Recursive Method
    public static boolean recursiveMethod(String input, int start, int end) {
        if (start >= end) return true;
        if (input.charAt(start) != input.charAt(end)) return false;
        return recursiveMethod(input, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check palindrome performance: ");
        String input = scanner.nextLine();

        long startTime, endTime;

        // Reverse String Method
        startTime = System.nanoTime();
        reverseStringMethod(input);
        endTime = System.nanoTime();
        System.out.println("UC3 Reverse String Method: " + (endTime - startTime) + " ns");

        // Two-Pointer Method
        startTime = System.nanoTime();
        twoPointerMethod(input);
        endTime = System.nanoTime();
        System.out.println("UC4 Two-Pointer Method: " + (endTime - startTime) + " ns");

        // Stack Method
        startTime = System.nanoTime();
        stackMethod(input);
        endTime = System.nanoTime();
        System.out.println("UC5 Stack Method: " + (endTime - startTime) + " ns");

        // Deque Method
        startTime = System.nanoTime();
        dequeMethod(input);
        endTime = System.nanoTime();
        System.out.println("UC7 Deque Method: " + (endTime - startTime) + " ns");

        // Recursive Method
        startTime = System.nanoTime();
        recursiveMethod(input, 0, input.length() - 1);
        endTime = System.nanoTime();
        System.out.println("UC9 Recursive Method: " + (endTime - startTime) + " ns");

        scanner.close();
    }
}
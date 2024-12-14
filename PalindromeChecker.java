import java.util.Scanner;
import java.lang.String;
public class PalindromeChecker {

    public static boolean isPalindrome(String input) {
        // Remove spaces, punctuation, and convert to lowercase
        String cleanedText = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int length = cleanedText.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanedText.charAt(i) != cleanedText.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String userInput = scanner.nextLine();

        if (isPalindrome(userInput)) {
            System.out.println("\"" + userInput + "\" is a palindrome.");
        } else {
            System.out.println("\"" + userInput + "\" is not a palindrome.");
        }
        
        scanner.close();
    }
}

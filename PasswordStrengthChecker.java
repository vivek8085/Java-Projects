package Level2;
import java.util.Scanner;

public class PasswordStrengthChecker{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int strength = calculatePasswordStrength(password);

        if (strength >= 5) {
            System.out.println("Password Strength: Strong");
        } else if (strength >= 3) {
            System.out.println("Password Strength: Moderate");
        } else {
            System.out.println("Password Strength: Weak");
        }

        scanner.close();
    }

    public static int calculatePasswordStrength(String password) {
        int strength = 0;

        if (password.length() >= 8) strength++;
        if (password.matches(".*[A-Z].*")) strength++;
        if (password.matches(".*[a-z].*")) strength++;
        if (password.matches(".*[0-9].*")) strength++;
        if (password.matches(".*[!@#$%^&*()-_+=<>?/].*")) strength++;

        return strength;
    }
}

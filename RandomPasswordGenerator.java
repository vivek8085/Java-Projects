import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLowercase = scanner.nextBoolean();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUppercase = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecial = scanner.nextBoolean();

        if (length <= 0 || !(includeNumbers || includeLowercase || includeUppercase || includeSpecial)) {
            System.out.println("Invalid input. Exiting program.");
            scanner.close();
            return;
        }

        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()-_+=<>?/";

        StringBuilder characterPool = new StringBuilder();
        if (includeNumbers) characterPool.append(numbers);
        if (includeLowercase) characterPool.append(lowercase);
        if (includeUppercase) characterPool.append(uppercase);
        if (includeSpecial) characterPool.append(special);

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        System.out.println("Generated Password: " + password.toString());
        scanner.close();
    }
}

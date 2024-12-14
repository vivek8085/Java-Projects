package Level2;
import java.io.*;
import java.util.Scanner;

public class EncrDecr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option: ");
        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the input file path: ");
        String inputFilePath = scanner.nextLine();

        System.out.print("Enter the output file path: ");
        String outputFilePath = scanner.nextLine();

        System.out.print("Enter the encryption/decryption key (integer): ");
        int key = scanner.nextInt();

        try {
            if (choice == 1) {
                encryptFile(inputFilePath, outputFilePath, key);
                System.out.println("File encrypted successfully.");
            } else if (choice == 2) {
                decryptFile(inputFilePath, outputFilePath, key);
                System.out.println("File decrypted successfully.");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }

    public static void encryptFile(String inputFilePath, String outputFilePath, int key) throws IOException {
        processFile(inputFilePath, outputFilePath, key);
    }

    public static void decryptFile(String inputFilePath, String outputFilePath, int key) throws IOException {
        processFile(inputFilePath, outputFilePath, -key);
    }

    private static void processFile(String inputFilePath, String outputFilePath, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character + key);
            }
        }
    }
}

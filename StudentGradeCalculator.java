import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of grades to be entered: ");
        int numberOfGrades = scanner.nextInt();

        if (numberOfGrades <= 0) {
            System.out.println("Invalid number of grades. Exiting program.");
            scanner.close();
            return;
        }

        double[] grades = new double[numberOfGrades];
        double total = 0;

        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            total += grades[i];
        }

        double average = total / numberOfGrades;
        System.out.printf("The average grade is: %.2f%n", average);

        scanner.close();
    }
}

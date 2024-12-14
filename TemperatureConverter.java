import java.util.Scanner;

public class TemperatureConverter {

    //Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    //Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0);

        // Perform the conversion based on the unit
        if (unit == 'C') {
            double convertedTemp = celsiusToFahrenheit(temperature);
            System.out.printf("%.2f°C is equal to %.2f°F%n", temperature, convertedTemp);
        } else if (unit == 'F') {
            double convertedTemp = fahrenheitToCelsius(temperature);
            System.out.printf("%.2f°F is equal to %.2f°C%n", temperature, convertedTemp);
        } else {
            System.out.println("Invalid unit. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }
        scanner.close();
    }
}
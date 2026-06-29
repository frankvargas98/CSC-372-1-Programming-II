import java.util.InputMismatchException;
import java.util.Scanner;

public class RecursiveProductRefactor {

    public static double calculateProduct(double[] numbers, int index) {
        // The Base Case, If the index matches the length, we are out of elements.
        if (index >= numbers.length) {
            return 1.0;
        }

        // The Recursive Case
        return numbers[index] * calculateProduct(numbers, index + 1);
    }

    private static double[] getNumbersFromUser(int totalNumbers) {
        Scanner scanner = new Scanner(System.in);
        double[] inputValues = new double[totalNumbers];

        System.out.println("Please enter " + totalNumbers + " numbers below:\n");

        for (int i = 0; i < totalNumbers; i++) {
            boolean isValidInput = false;
            while (!isValidInput) {
                try {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    inputValues[i] = scanner.nextDouble();
                    isValidInput = true; // Input accepted, move to next index
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid decimal or integer number.");
                    scanner.next(); // Clear the bad input token from the scanner buffer
                }
            }
        }
        scanner.close();
        return inputValues;
    }

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("  REFACTOR: SEPARATED RECURSIVE CALCULATOR  ");
        System.out.println("============================================");

        // Collect data cleanly via dedicated helper method
        double[] userNumbers = getNumbersFromUser(5);

        // Compute results via pure recursive method starting at index 0
        double totalProduct = calculateProduct(userNumbers, 0);

        // Present output
        System.out.println("\n--------------------------------------------");
        System.out.printf("The total product of all 5 numbers is: %,.2f%n", totalProduct);
        System.out.println("============================================");
    }
}
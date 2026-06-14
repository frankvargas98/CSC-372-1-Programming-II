import java.util.Scanner;

public class RecursiveProduct {
    public static double multiplyNumbers(int count, Scanner scanner) {
        // The Base Case
        // When we need 0 more numbers, return 1
        if (count == 0) {
            return 1.0;
        }

        // The Recursive Case
        // Ask the user for the current number
        System.out.print("Enter a number (" + count + " remaining): ");
        double currentNumber = scanner.nextDouble();

        // Multiply the current number by the result of the NEXT recursive call
        return currentNumber * multiplyNumbers(count - 1, scanner);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================");
        System.out.println("  RECURSIVE FIVE-NUMBER PRODUCT CALCULATOR  ");
        System.out.println("============================================");
        System.out.println("Please enter five numbers below:\n");

        // Start the recursion requesting 5 numbers
        double totalProduct = multiplyNumbers(5, scanner);

        // Final result
        System.out.println("\n--------------------------------------------");
        System.out.printf("The total product of all 5 numbers is: %,.2f%n", totalProduct);
        System.out.println("============================================");

        // Close the scanner resource
        scanner.close();
    }
}
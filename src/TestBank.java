import java.util.Scanner;

public class TestBank {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   BANK ACCOUNT ACCOUNT CREATION SYSTEM ");
        System.out.println("========================================");

        // Gather Account Holder Info
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Account ID (Numbers only): ");
        int accountID = scanner.nextInt();

        System.out.print("Enter Interest Rate (e.g., 1.5 for 1.5%): ");
        double interestRate = scanner.nextDouble();

        // Instantiate the CheckingAccount using the input interest rate
        CheckingAccount myChecking = new CheckingAccount(interestRate);
        myChecking.setFirstName(firstName);
        myChecking.setLastName(lastName);
        myChecking.setAccountID(accountID);

        // Display Initial Account Summary
        System.out.println("\nAccount successfully created!");
        myChecking.displayAccount();

        // 1. Test Deposit
        System.out.print("\nEnter an amount to DEPOSIT: $");
        double depositAmt = scanner.nextDouble();
        myChecking.deposit(depositAmt);
        System.out.println("\n--- Updated Account Status ---");
        myChecking.displayAccount();

        // 2. Test Withdrawal (You can test normal or overdraft here)
        System.out.print("\nEnter an amount to WITHDRAW: $");
        double withdrawAmt = scanner.nextDouble();

        // This will automatically process overdraft fees if you exceed the balance
        myChecking.processWithdrawal(withdrawAmt);

        System.out.println("\n--- Final Account Status ---");
        myChecking.displayAccount();

        // Close the scanner to prevent resource leaks
        scanner.close();
        System.out.println("System session closed. Thank you!");
    }
}
public class CheckingAccount extends BankAccount {
    // Additional attribute
    private double interestRate;

    // Constructor
    public CheckingAccount(double interestRate) {
        super(); // Calls the superclass constructor to initialize balance to 0
        this.interestRate = interestRate;
    }

    // Process Withdrawal with Overdraft Logic
    public void processWithdrawal(double amount) {
        // Perform the standard withdrawal using the superclass method
        super.withdrawal(amount);

        // Check if the account is now overdrafted
        if (getBalance() < 0) {
            super.withdrawal(30.0); // Deduct the $30 overdraft fee
            System.out.println("\n[ALERT] Overdraft occurred! A $30.00 fee has been assessed.");
            System.out.printf("Negative Balance (including fee): $%.2f%n", getBalance());
        }
    }

    // Display Account (Includes superclass attributes and interest rate)
    public void displayAccount() {
        super.accountSummary(); // Displays basic account info
        System.out.printf("Interest Rate: %.2f%%%n", interestRate);
        System.out.println("-----------------------");
    }

    // Getter and Setter for interestRate
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
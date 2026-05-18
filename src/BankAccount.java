public class BankAccount {
    // Fields
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Initializes balance to zero
    public BankAccount() {
        this.balance = 0.0;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdrawal method
    public void withdrawal(double amount) {
        this.balance -= amount;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    // Account Summary
    public void accountSummary() {
        System.out.println("--- Account Summary ---");
        System.out.println("Account ID: " + accountID);
        System.out.println("Account Holder: " + firstName + " " + lastName);
        System.out.printf("Balance: $%.2f%n", balance);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI extends JFrame {
    private BankAccount account = new BankAccount(); // Re-using BankAccount class
    private JTextField amountField = new JTextField(10);
    private JLabel balanceLabel = new JLabel("Balance: $0.00");

    public BankGUI() {
        // Sets up the window
        setTitle("Bank Balance App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Creates the panel
        JPanel panel = new JPanel();

        // Components
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");

        // ActionListeners
        depositBtn.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            updateBalance();
        });

        withdrawBtn.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            account.withdrawal(amount);
            updateBalance();
        });

        // Add to Panel
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(depositBtn);
        panel.add(withdrawBtn);
        panel.add(balanceLabel);

        add(panel);
        setVisible(true);
    }

    private void updateBalance() {
        balanceLabel.setText(String.format("Balance: $%.2f", account.getBalance()));
    }

    public static void main(String[] args) {
        new BankGUI();
    }
}
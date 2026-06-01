import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CriticalUI extends JFrame {
    private JTextArea textBox;
    private Color randomGreen;
    private String greenHexCode;

    public CriticalUI() {
        // 1. Setup of the Main Window
        setTitle("Menu Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Generates one initial random green color
        Random rand = new Random();
        float hue = 0.25f + rand.nextFloat() * 0.15f;
        randomGreen = Color.getHSBColor(hue, 0.8f, 0.8f);

        // Formating the color to a readable hex string to display on the menu
        greenHexCode = String.format("#%02x%02x%02x", randomGreen.getRed(), randomGreen.getGreen(), randomGreen.getBlue());

        // 2. Creates the Menu Bar and Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File Options");

        // Creates the four menu items
        JMenuItem item1 = new JMenuItem("1. Print Date and Time");
        JMenuItem item2 = new JMenuItem("2. Save to log.txt");
        // Setting the menu text to display the specific hue generated for this run
        JMenuItem item3 = new JMenuItem("3. Change Background (" + greenHexCode + ")");
        JMenuItem item4 = new JMenuItem("4. Exit");

        // 3. Creates the Text Box
        textBox = new JTextArea();
        // Wrapping it in a ScrollPane in case the text gets too long
        JScrollPane scrollPane = new JScrollPane(textBox);

        // Option 1: Print Date and Time
        item1.addActionListener(e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            textBox.append("Logged: " + formatter.format(now) + "\n");
        });

        // Option 2: Write to log.txt
        item2.addActionListener(e -> {
            try (FileWriter writer = new FileWriter("log.txt")) {
                writer.write(textBox.getText());
                JOptionPane.showMessageDialog(this, "Success: Contents written to log.txt!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage());
            }
        });

        // Option 3: Change Background to the random green
        item3.addActionListener(e -> {
            // Change the background of the content pane
            getContentPane().setBackground(randomGreen);

            // Optional: Make the text box slightly transparent so you can see the background color behind it
            textBox.setOpaque(false);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);

            textBox.append("Background changed to hue: " + greenHexCode + "\n");
        });

        // Option 4: Exit
        item4.addActionListener(e -> {
            System.exit(0);
        });

        // 5. Assembles everything
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Add the text box to the center of the frame
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Ensure GUI runs on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new CriticalUI().setVisible(true);
        });
    }
}
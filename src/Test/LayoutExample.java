import javax.swing.*;
import java.awt.*;

public class LayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Setting the Layout Manager to BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Adding components to certain regions
        panel.add(new JButton("North"), BorderLayout.NORTH);
        panel.add(new JButton("South"), BorderLayout.SOUTH);
        panel.add(new JButton("Center"), BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}
package Swing;
// 2. JPanel, JLabel, JButton
import javax.swing.*;

public class LableButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lable and Button Example");
        JPanel panel = new JPanel(); // container for components

        JLabel label = new JLabel("Click the button");
        JButton button = new JButton("Click Me!");

        panel.add(label); // add components to panel
        panel.add(button);

        frame.add(panel); // add panel to frame
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

package Swing;
// Java 8 event listener using lambda

import javax.swing.*;

public class LambdaEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lambda Event Example");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Waiting...");
        JButton button = new JButton("Click Me");

        // Java 8 lambda
        button.addActionListener(e -> label.setText("You clicked the button!"));

        panel.add(button);
        panel.add(label);
        frame.add(panel);

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

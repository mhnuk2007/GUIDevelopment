package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Action Listner Example");
        JPanel panel = new JPanel();

        JLabel label = new JLabel("No button pressed yet");
        JButton button = new JButton("Click Me!");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button was clicked!");
            }
        });

        panel.add(button);
        panel.add(label);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

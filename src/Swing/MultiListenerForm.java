package Swing;
/*
🏁 Mini Project: Interactive Form with Multiple Listeners
🔹 UI Components to Use:
JTextField → For name input

JButton → Submit button

JLabel → To show messages

JPanel → Main container

🎯 Requirements:
1. Name Field (JTextField)
Attach a KeyListener

✅ Show a message in a label as the user types (e.g., “Typing: H”)

2. Submit Button (JButton)
Use a lambda ActionListener

✅ On click, display "Hello, [name]" in the label

❌ If the field is empty, show: "Name can't be empty!"

3. Hover Effect (Optional but fun)
Use MouseListener

✅ When mouse hovers over the button, change button text to “Ready?”

✅ When mouse exits, restore text to “Submit”
 */

import javax.swing.*;
import java.awt.event.*;

public class MultiListenerForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Interactive Form");
        JPanel panel = new JPanel();

        JTextField nameField = new JTextField(15);
        JLabel typingLabel = new JLabel("Start typing...");
        JButton submitButton = new JButton("Submit");
        JLabel messageLabel = new JLabel();

        // KeyListener
        nameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                typingLabel.setText("Typing: " + nameField.getText());
            }
        });

        // Lambda ActionListener
        submitButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                messageLabel.setText("Name can't be empty!");
            } else {
                messageLabel.setText("Hello, " + name);
            }
        });

        // MouseListener for hover effect
        submitButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                submitButton.setText("Ready?");
            }

            public void mouseExited(MouseEvent e) {
                submitButton.setText("Submit");
            }
        });

        panel.add(new JLabel("Enter your name:"));
        panel.add(nameField);
        panel.add(typingLabel);
        panel.add(submitButton);
        panel.add(messageLabel);

        frame.add(panel);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

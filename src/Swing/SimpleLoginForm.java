package Swing;
/*
🏁 Mini Project: Simple Login Form UI
Use all components together:

🔹 Requirements:
Name (JTextField)
Password (JPasswordField)
Gender (JRadioButtons)
Skills (JCheckBoxes)
Submit Button → Show input in dialog
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleLoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Login Form");
        JPanel panel = new JPanel();

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        JLabel skillsLabel = new JLabel("Skills");
        JCheckBox javaCheckBox = new JCheckBox("Java");
        JCheckBox pythonCheckBox = new JCheckBox("Python");
        JButton submitButton = new JButton("Submit");
        JLabel submitSuccess = new JLabel();

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(genderLabel);
        panel.add(maleButton);
        panel.add(femaleButton);
        panel.add(skillsLabel);
        panel.add(javaCheckBox);
        panel.add(pythonCheckBox);
        panel.add(submitButton);
        panel.add(submitSuccess);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Not selected";
                String skills = "";
                if (javaCheckBox.isSelected()) skills += "Java ";
                if (pythonCheckBox.isSelected()) skills += "Python";

                if (name.equalsIgnoreCase("Honey") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(frame,
                            "Login Successful!\n" +
                                    "Name: " + name + "\n" +
                                    "Gender: " + gender + "\n" +
                                    "Skills: " + skills,
                            "Welcome", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid credentials!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);




    }
}

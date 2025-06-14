package Swing;
//4. JCheckBox, JRadioButton, ButtonGroup
import javax.swing.*;

public class ChoiceExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Choices Example");
        JPanel panel = new JPanel();

        JCheckBox checkBox1 = new JCheckBox("Java");
        JCheckBox checkBox2 = new JCheckBox("Python");

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup(); // Ensure one selection only
        genderGroup.add(male);
        genderGroup.add(female);

        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(male);
        panel.add(female);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

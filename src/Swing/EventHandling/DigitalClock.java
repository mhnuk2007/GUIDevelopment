package Swing.EventHandling;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalClock {
    // JLabel to display the current time
    private JLabel timeLabel = new JLabel();

    // Method to create the GUI and show the clock
    public void createAndShowGUI() {
        // Create a new window (JFrame)
        JFrame frame = new JFrame("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the app on exit
        frame.setSize(300, 100); // Set window size
        frame.setLayout(new FlowLayout()); // Use FlowLayout to arrange components in a row

        // Initialize the label to show the time
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font size and style
        frame.add(timeLabel); // Add the label to the frame

        // Create a timer that triggers every 1000 milliseconds (1 second)
        // On each tick, it calls the updateTime() method
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start(); // Start the timer

        updateTime(); // Display current time immediately when GUI opens
        frame.setVisible(true); // Show the window
    }

    // Method to get the current time and update the label
    private void updateTime() {
        LocalTime time = LocalTime.now(); // Get current system time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // Define time format
        timeLabel.setText(time.format(formatter)); // Set formatted time on the label
    }

    // Main method - starting point of the application
    public static void main(String[] args) {
        // Ensure GUI updates are thread-safe
        SwingUtilities.invokeLater(() -> new DigitalClock().createAndShowGUI());
    }
}

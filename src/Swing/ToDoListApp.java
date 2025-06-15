package Swing;
/*
2. To-Do List App
Simple app to add, mark as complete, and delete tasks.

Features:
Add task (input + button)
Show tasks in a list
Mark complete with checkbox
Delete selected task
Concepts: JList, DefaultListModel, JScrollPane, listeners.
 */

import javax.swing.*;
import java.awt.*;

public class ToDoListApp {
    public static void main(String[] args) {
        // Schedule GUI creation on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> new ToDoListApp().createAndShowGUI());
    }

    // Model to hold the list of tasks
    private DefaultListModel<String> taskModel;

    // UI component to display the list of tasks
    private JList<String> taskList;

    // Create and show the GUI
    private void createAndShowGUI() {
        // Create the main application window
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center the frame

        // Input field for entering new tasks
        JTextField taskInput = new JTextField();

        // Button to add a new task
        JButton addButton = new JButton("Add Task");

        // Button to delete the selected task
        JButton deleteButton = new JButton("Delete Selected");

        // Initialize the task model and bind it to the JList
        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only one selection at a time
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));// Set font for better readability

        // Wrap the task list in a scroll pane
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Add a task when the "Add" button is clicked or Enter key is pressed in the input field
        addButton.addActionListener(e -> addTask(taskInput));
        taskInput.addActionListener(e -> addTask(taskInput));

        // Delete the selected task when the "Delete Selected" button is clicked
        deleteButton.addActionListener(e -> deleteTask());

        //Panel for task input and add button
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        //panel for the delete button
        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(deleteButton, BorderLayout.CENTER);

        // Add components to the main frame with appropriate layout
        frame.setLayout(new BorderLayout(10, 10));
        frame.add(inputPanel, BorderLayout.NORTH); // Top: input field + add button
        frame.add(scrollPane, BorderLayout.CENTER); // Center: task list
        frame.add(controlPanel, BorderLayout.SOUTH); // Bottom: delete button

        frame.setVisible(true); // show window
        taskInput.requestFocusInWindow(); // Focus on input field initially
    }

    // Method to add a new task to the list
    private void addTask(JTextField taskInput) {
        String task = taskInput.getText().trim(); // Get user input
        if (!task.isEmpty()) {
            // Add the task to the list with an unchecked box symbol
            taskModel.addElement("☐" + task);
            taskInput.setText(""); // Clear input field
        }
    }

    // Method to delete the selected task from the list
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex(); // get selected task index
        if (selectedIndex != -1) {
            // Ask user for confirmation before deleting
            int confirm = JOptionPane.showConfirmDialog(
                    null, "Delete selected task?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm==JOptionPane.YES_OPTION){
                taskModel.remove(selectedIndex); // Remove task if confirmed
            }
        } else {
            // Show warning if no task is selected
            JOptionPane.showMessageDialog(null, "No task selected!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
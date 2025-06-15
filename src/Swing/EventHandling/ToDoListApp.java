package Swing.EventHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ToDoListApp {
    private DefaultListModel<String> model;
    private JList<String> list;

    public void createAndShowGUI() {
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        model = new DefaultListModel<>();
        list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(list), BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        // Add task
        ActionListener addTask = e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                model.addElement("☐ " + task);
                taskField.setText("");
            }
        };

        addButton.addActionListener(addTask);
        taskField.addActionListener(addTask);

        // Delete task
        deleteButton.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if (index != -1) {
                model.remove(index);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoListApp().createAndShowGUI());
    }
}

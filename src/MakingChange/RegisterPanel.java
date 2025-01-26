package MakingChange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*; // For collections like Map and List

/**
 * A GUI panel for the Register application that calculates and displays change for a given amount.
 */
public class RegisterPanel extends JPanel {
    private final Register register = new Register(); // The Register instance to handle change calculation
    private final JTextField input = new JTextField(10); // Input field for entering the amount
    private final PursePanel changePanel = new PursePanel(); // Panel to display the calculated change

    /**
     * Constructor to set up the RegisterPanel layout and components.
     */
    public RegisterPanel() {
        // Set the main layout of the panel
        setLayout(new BorderLayout());

        // Create a sub-panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter amount: ")); // Label for the input field
        inputPanel.add(input); // Add the input field to the panel
        input.addActionListener(new InputListener()); // Attach action listener to handle input

        // Add the input panel to the top of the RegisterPanel
        add(inputPanel, BorderLayout.NORTH);

        // Add the change display panel to the center of the RegisterPanel
        add(changePanel, BorderLayout.CENTER);
    }

    /**
     * Inner class to handle input actions from the user.
     */
    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Parse the input text into a double (amount)
                double amount = Double.parseDouble(input.getText());

                // Use the Register to calculate the change
                Purse change = register.makeChange(amount);

                // Update the PursePanel to display the calculated change
                changePanel.setPurse(change);
            } catch (NumberFormatException ex) {
                // Show an error dialog if the input is not a valid number
                JOptionPane.showMessageDialog(
                        null,
                        "Please enter a valid number!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}

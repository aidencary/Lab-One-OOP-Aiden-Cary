package MakingChange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
private final Register register = new Register();
private final JTextField input = new JTextField(10);
private final PursePanel changePanel = new PursePanel();

public RegisterPanel() {
    setLayout(new BorderLayout());

    JPanel inputPanel = new JPanel(); // The panel used to hold the input field and label
    inputPanel.add(new JLabel("Enter amount: "));
    inputPanel.add(input);
    input.addActionListener(new InputListener()); // Will need to change

    add(inputPanel, BorderLayout.NORTH);
    add(changePanel, BorderLayout.CENTER);
  }

  // Inner class used to handle input actions
  private class InputListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(input.getText()) * 100;
            Purse change = register.makeChange(amount / 100.0); // Calculates the change
            changePanel.setPurse(change); // Update the change panel with the calculated purse
        } catch (NumberFormatException ex) { // Catches exceptions
            JOptionPane.showMessageDialog(null, "Please enter a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  }

}



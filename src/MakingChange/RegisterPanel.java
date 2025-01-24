package MakingChange;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
/*
* RegisterPanel - Calculates and displayed the change for a given monetary input
* Purse Panel is used to display the calculated change
* Register is using to perform the change calculation
*
*/
public class RegisterPanel extends JPanel {
    private final Register register = new Register();
    private final PursePanel changePanel = new PursePanel();

    public RegisterPanel() {
        setLayout(new BorderLayout());

        // Display the change panel
        add(changePanel, BorderLayout.CENTER);

        // Request input from the console
        getInputFromConsole();
    }

    /*
    * Requests input from the user in the console
    * Calculates the change
    * Updates PursePanel with the result
    */
    private void getInputFromConsole() {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for input
        System.out.print("Enter the amount of money: ");

        try {
            double amount = Double.parseDouble(scanner.nextLine()); // Read and parse the amount entered
            // Check if the amount is valid
            if (amount <= 0 || amount < 0.01) {
                System.out.println("Empty purse");
            } else {
                Purse change = register.makeChange(amount); // Calculate the change
                changePanel.setPurse(change); // Update the change panel with the calculated purse
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}



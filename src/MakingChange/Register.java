package MakingChange;

import java.util.Map;
// Registers handles the logic for making change
public class Register {
    // Creates an array list of available denominations in descending order of value
    // Idea for this was found on the Java with Baarsch Discord
    private static final Denomination[] US_CURRENCY = {
            new Denomination("Hundred-Dollar Note", 100.0, "bill", "images/hundred.png"),
            new Denomination("Fifty-Dollar Note", 50.0, "bill", "images/fifty.png"),
            new Denomination("Twenty-Dollar Note", 20.0, "bill", "images/twenty.png"),
            new Denomination("Ten-Dollar Note", 10.0, "bill", "images/ten.png"),
            new Denomination("Five-Dollar Note", 5.0, "bill", "images/five.png"),
            new Denomination("One-Dollar Note", 1.0, "bill", "images/dollar.png"),
            new Denomination("Quarter", 0.25, "coin", "images/quarter.png"),
            new Denomination("Dime", 0.10, "coin", "images/dime.png"),
            new Denomination("Nickel", 0.05, "coin", "images/nickel.png"),
            new Denomination("Penny", 0.01, "coin", "images/penny.png")
    };
/*
* Calculates the optimal distribution of US currency denominations in order to make change to the user inputted amt
* Returns a Purse object contain the calculated distributions of denominations
*/
    public Purse makeChange(double amt) {
        // Convert the amt value to an integer to avoid "losing" a penny.
        int amountInCents = (int) Math.round(amt * 100);
        Purse purse = new Purse();

        // Uses an advanced for loop to iterate through each denom in descending order of value
        for (Denomination denom : US_CURRENCY) {
            // Convert the denom value to cents
            int denomValueInCents = (int) Math.round(denom.amt() * 100);

            // Determines how many of the denomination can be used
            int count = amountInCents / denomValueInCents;

            if (count > 0) {
                // Add the denomination and count to the purse
                purse.add(denom, count);
                // Subtract the value of the added denoms from the total amount
                amountInCents -= count * denomValueInCents;
            }
            // If no remaining amount is left, break out of the loop early
            if (amountInCents == 0) {
                break;
            }
        }
        // Checks if the purse contains any change
        if (purse.isEmpty()) {
            System.out.println("Empty purse");
        } else {
            // Retrieve the purse contents in the order of the original currency array
            Map<Denomination, Integer> orderedContents = purse.getContentsInOrder(US_CURRENCY);
            for (Map.Entry<Denomination, Integer> entry : orderedContents.entrySet()) {
                // Print the contents of the purse (denomination name and count)
                System.out.println(entry.getValue() + " " + entry.getKey().name());
            }
        }
        return purse;
    }
}

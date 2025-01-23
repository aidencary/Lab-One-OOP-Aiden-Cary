package MakingChange;

public class Register {
    // Creates an array list of available denominations in descending order of value
    // Idea for this was found on the Java with Baarsch Discord
    private static final Denomination[] US_CURRENCY = {
            new Denomination("Hundred-Dollar Note", 100.0, "bill", "images/hundred.png"),
            new Denomination("Fifty-Dollar Note", 50.0, "bill", "images/fifty.png"),
            new Denomination("Twenty-Dollar Note", 20.0, "bill", "images/twenty.png"),
            new Denomination("Ten-Dollar Note", 10.0, "bill", "images/ten.png"),
            new Denomination("Five-Dollar Note", 5.0, "bill", "images/five.png"),
            new Denomination("One-Dollar Note", 1.0, "bill", "images/one.png"),
            new Denomination("Quarter", 0.25, "coin", "images/quarter.png"),
            new Denomination("Dime", 0.10, "coin", "images/dime.png"),
            new Denomination("Nickel", 0.05, "coin", "images/nickel.png"),
            new Denomination("Penny", 0.01, "coin", "images/penny.png")
    };

    // Generate the change for the user inputted amount
    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        for (Denomination denom : US_CURRENCY) { // Iterates thorugh each denomination
            int count = (int) (amt / denom.amt()); // Calculates how many of the denomination can fit into the amount
            if (count > 0) {
                purse.add(denom, count);
                amt -= count * denom.amt();
            }
        }
        return purse; // Returns the purse with the change
    }
}

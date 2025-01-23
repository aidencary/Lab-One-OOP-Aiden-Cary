package MakingChange;

import java.util.HashMap;
import java.util.Map;

public class Purse {
    // Uses a hash map to keep track of the number of each denomination in the purse.
    public final Map<Denomination, Integer> cash = new HashMap<>();

    // Add a specific number of a denomination to the purse
    public void add(Denomination type, int num) {
        // Update the count or set it if it is not present
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    // Remove a specific number of a denomination and return the total value removed
    public double remove(Denomination type, int num) {
        int currentCount = cash.getOrDefault(type, 0); // Gets the current count of the denomination
        int toRemove = Math.min(num, currentCount); // Makes sure that we don't remove more than what there is available
        cash.put(type, currentCount - toRemove); // Updates the count in the map
        return toRemove * type.amt(); // Return the total value that is removed
    }

    // Calculate the total value of the purse
    public double getValue() {
        double total = 0.0;
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            Denomination denom = entry.getKey(); // Gets the key for the Denomination
            int amount = entry.getValue(); // Gets the value

            // Add to the total
            total += denom.amt() * amount; // Reps the denom's worth per piece * the number of pieces
        }
        return total;
    }

    // Provides a string representation of the purse contents
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sb.append(entry.getKey().name()) // Appends the name of the denomination
                    .append(" x ") // Appends the count prefix
                    .append(entry.getValue()) // Appends the count
                    .append("\n");
        }
        return sb.toString();
    }
}

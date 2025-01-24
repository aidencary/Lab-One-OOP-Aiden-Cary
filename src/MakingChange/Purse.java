package MakingChange;

import java.util.*;

public class Purse {
    // Uses a linked hash map to keep track of the number of each denomination in the purse.
    public final Map<Denomination, Integer> cash = new LinkedHashMap<>();

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

    // Calculate the total value of the purse (sorted by denomination value in descending order)
    public double getValue() {
        double total = 0.0;
        List<Map.Entry<Denomination, Integer>> sortedEntries = new ArrayList<>(cash.entrySet());
        sortedEntries.sort((entry1, entry2) -> Double.compare(entry2.getKey().amt(), entry1.getKey().amt())); // Sort by denomination value in descending order

        // Add up the total value based on sorted entries
        for (Map.Entry<Denomination, Integer> entry : sortedEntries) {
            Denomination denom = entry.getKey();
            int amount = entry.getValue();
            total += denom.amt() * amount;
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
    // Returns the contents of the purse ordered according to the provided currency order.
    public Map<Denomination, Integer> getContentsInOrder(Denomination[] currencyOrder) {
        Map<Denomination, Integer> orderedCash = new LinkedHashMap<>();
        for (Denomination denom : currencyOrder) {
            if (cash.containsKey(denom)) {
                orderedCash.put(denom, cash.get(denom));
            }
        }
        return orderedCash;
    }

    // If the purse is empty (contains no denoms) then it returns false
    public boolean isEmpty() {
        return cash.isEmpty();
    }
}


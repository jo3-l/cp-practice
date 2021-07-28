package binarysearch;

public class DeleteRepeatedCharacterWithCosts {
    public int solve(String s, int[] costs) {
        int minCost = 0;

        int i = 0;
        while (i < s.length()) {
            int totalCost = costs[i];
            int maxCost = costs[i];
            char c = s.charAt(i++);
            while (i < s.length() && s.charAt(i) == c) {
                totalCost += costs[i];
                maxCost = Math.max(maxCost, costs[i]);
                i++;
            }

            minCost += totalCost - maxCost;
        }
        return minCost;
    }
}

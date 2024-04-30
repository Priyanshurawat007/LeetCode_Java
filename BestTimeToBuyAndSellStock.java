import java.util.*;

public class Solution {
    public static int maximumProfit(ArrayList<Integer> prices) {
        if (prices == null || prices.size() <= 1) {
            return 0; // If the list is empty or has only one element, return 0
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update the minimum price encountered so far
            if (price < minPrice) {
                minPrice = price;
            }

            // Calculate the potential profit if selling at the current price
            int potentialProfit = price - minPrice;

            // Update the maximum profit found so far
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>(Arrays.asList(2, 100, 150, 120));
        int maxProfit = maximumProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit); // Output: 148
    }
}

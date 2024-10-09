/*
Problem : The Coin Change Problem
You are given an integer array coins[] of size n, 
where each element represents the denomination of a coin. 
You are also given an integer amount, representing the total amount of money. 
The task is to find the minimum number of coins required to make up the given amount.

Input : coins = [1, 2, 5], amount = 11

Output : 3
*/

package problems;

import java.util.Arrays;

public class Problem_30 {

    // Method to find the minimum number of coins required
    public static int coinChange(int[] coins, int amount) {
        // Create a DP array to store the minimum coins for each amount from 0 to amount
        int[] dp = new int[amount + 1];
        
        // Initialize the dp array with a large value, as we are looking for the minimum
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins are needed to make up amount 0
        dp[0] = 0;

        // Iterate over all amounts from 1 to the given amount
        for (int i = 1; i <= amount; i++) {
            // Check each coin
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If the amount can't be made up by any combination of the coins, return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        // Output: 3 (11 = 5 + 5 + 1)
        int result = coinChange(coins, amount);
        System.out.println("Minimum number of coins required: " + result);
    }
}

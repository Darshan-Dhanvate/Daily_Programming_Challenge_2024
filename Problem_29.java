/*
Problem : Fibonacci Sequence using Dynamic Programming
You are given an integer n. Your task is to calculate the n-th 
Fibonacci number using Dynamic Programming.

Input : 5

Output : 5
*/

package problems;

public class Problem_29 {
    
    // Method to calculate the n-th Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        // Create a DP array to store Fibonacci numbers up to n
        int[] dp = new int[n + 1];
        dp[0] = 0; // F(0) = 0
        dp[1] = 1; // F(1) = 1

        // Build the Fibonacci sequence using the DP approach
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the n-th Fibonacci number
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("The " + n + "-th Fibonacci number is: " + fibonacci(n)); // Output: 5
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // dp[i] is the number of ways to make amount i
        dp[0] = 1; // Base case: one way to make amount 0

        for (int coin : coins) { // For each coin
          for (int i = coin; i <= amount; i++) { // For each amount
              dp[i] += dp[i - coin]; // Add the number of ways to make amount i - coin
          }
        }

        return dp[amount]; // Return the number of ways to make amount
    }
}
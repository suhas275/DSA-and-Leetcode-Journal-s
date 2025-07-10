import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // dp[i] will store the minimum number of coins needed for amount i
        int[] dp = new int[amount + 1];

        // Initialize dp with a large value (infinity substitute)
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // Base case: 0 coins to make amount 0

        // Iterate over all amounts from 1 to amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    // If coin can be used, take min coins for current amount
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // If dp[amount] was not updated, return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solver = new CoinChange();
        
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Output: " + solver.coinChange(coins1, amount1)); // Output: 3

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Output: " + solver.coinChange(coins2, amount2)); // Output: -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Output: " + solver.coinChange(coins3, amount3)); // Output: 0
    }
}


class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int a = 1; a <= amount; a++) {
            for(int c = 0; c < coins.length; c++) {
                int ans = a - coins[c];
                if(ans >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[ans]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
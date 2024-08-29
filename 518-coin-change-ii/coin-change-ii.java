class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        Integer[][] dp= new Integer[n + 1][amount + 1];
        return changeHelper(amount, coins, 0, dp);
    }

    public int changeHelper(int amount, int[] coins, int index, Integer[][] dp) {
        if(amount == 0) return 1;
        if(index > coins.length - 1 || amount < 0) return 0;

        if(dp[index][amount] != null) return dp[index][amount];

        int sameCoin = changeHelper(amount - coins[index], coins, index, dp);
        int nextCoin = changeHelper(amount, coins, index + 1, dp);

        return dp[index][amount] = sameCoin + nextCoin;
    }
}
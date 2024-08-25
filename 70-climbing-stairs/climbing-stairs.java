class Solution {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n + 1];
        return climbStairsHelper(n, dp);
    }

    public int climbStairsHelper(int n, Integer[] dp) {
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(dp[n] != null) 
            return dp[n];

        return dp[n] = climbStairsHelper(n-1, dp) + climbStairsHelper(n-2, dp);
    }
}
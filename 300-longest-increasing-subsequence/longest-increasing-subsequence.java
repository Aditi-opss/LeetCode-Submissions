class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length + 1][nums.length + 1];
        return lengthOfLISHelper(nums, 0, -1, dp);
    }

    public int lengthOfLISHelper(int[] nums, int index, int prev, Integer[][] dp) {
        if(index >= nums.length) return 0;

        if(dp[index][prev + 1] != null) {
            return dp[index][prev + 1];
        }

        int x = 0;
        if(prev == -1 || nums[index] > nums[prev]){
            x = 1 + lengthOfLISHelper(nums, index + 1, index, dp);
        }
        int y = lengthOfLISHelper(nums, index + 1, prev, dp);

        return dp[index][prev + 1] = Math.max(x, y);
    }
}
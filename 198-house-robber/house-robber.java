class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length + 1];
        int house0 = robHelper(nums, 0, dp);
        int house1 = robHelper(nums, 1, dp);
        return Math.max(house0, house1);
    }

    public int robHelper(int[] nums, int index, Integer[] dp) {
        if(index >= nums.length) return 0;

        if(dp[index] != null) return dp[index];

        int x = nums[index] + robHelper(nums, index + 2, dp);
        int y = nums[index] + robHelper(nums, index + 3, dp);

        return dp[index] = Math.max(x, y);
    }
}
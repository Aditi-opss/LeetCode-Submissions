class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        Integer[] dp = new Integer[nums.length];
        Integer[] dp1 = new Integer[nums.length + 1];
        Integer[] dp2 = new Integer[nums.length + 1];
        int house0 = robHelper(nums, 0, nums.length - 1, dp);

        int house1 = robHelper(nums, 1, nums.length, dp1);
        int house2 = robHelper(nums, 2, nums.length, dp2);
        
        return Math.max(house0, Math.max(house1, house2));
    }

    public int robHelper(int[] nums, int index, int n, Integer[] dp) {
        if(index >= n)
            return 0;
        if(dp[index] != null)
            return dp[index];
        int x = nums[index] + robHelper(nums, index + 2, n, dp);
        int y = nums[index] + robHelper(nums, index + 3, n, dp);

        return dp[index] = Math.max(x, y);
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int toFind = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;
        else {
            toFind = sum / 2;
        }
        Boolean[][] dp = new Boolean[nums.length + 1][toFind + 1]; 
        return canPartitionHelper(nums, 0, 0, toFind, dp);
    }

    public boolean canPartitionHelper(int[] nums, int index, int sum, int target, Boolean[][] dp) {
        if(sum == target) return true;
        if(index >= nums.length || sum > target) return false;

        if(dp[index][sum] != null) return dp[index][sum];

        boolean pick = canPartitionHelper(nums, index + 1, sum + nums[index], target, dp);
        boolean nonPick = canPartitionHelper(nums, index + 1, sum, target, dp);

        return dp[index][sum] = pick || nonPick;
    }
}
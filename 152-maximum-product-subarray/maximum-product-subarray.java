class Solution {

    public int maxProduct(int[] nums) {
        int mn = nums[0], mx = nums[0], ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, mx);
            if(nums[i] < 0) {
                int temp = mn;
                mn = mx;
                mx = temp;
            }
            mx = Math.max(nums[i], mx * nums[i]);
            mn = Math.min(nums[i],nums[i] * mn);
        }
        ans = Math.max(ans, mx);
        return ans;
    }
}
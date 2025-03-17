class Solution {
    public int rob(int[] nums) {
        int prev1 = 0, prev2 = 0, n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        int max1 = robRange(nums, 0, n-2);
        
        int max2 = robRange(nums, 1, n-1);
        
        return Math.max(max1, max2);
    }
    private int robRange(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0; 
        
        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + nums[i]);
            prev2 = temp;
        }
        
        return prev1;
    }
}
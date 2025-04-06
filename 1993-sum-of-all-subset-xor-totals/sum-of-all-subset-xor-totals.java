class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    private int helper(int[] nums, int i, int xor){
        if(i==nums.length) return xor;
        int withElement = helper(nums,i+1,xor^nums[i]);
        int withoutElement = helper(nums,i+1,xor);
        return withElement + withoutElement;
    }
}
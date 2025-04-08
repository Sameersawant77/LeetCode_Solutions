class Solution {
    public int minimumOperations(int[] nums) {
        int[] hash = new int[101];
        for (int i = nums.length - 1; i >= 0; --i) {
            if (++hash[nums[i]] > 1) 
                return (i + 3) / 3;
        }
        return 0;
    }
}
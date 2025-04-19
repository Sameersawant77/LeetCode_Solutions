class Solution {
    public long countAtMost(int[] nums, long comp) {
        long ans = 0;
        int j = nums.length - 1;
        for (int i = 0; i < j; i++) {
            while (i < j && nums[i] + nums[j] > comp) j--;
            ans += j - i;
        }
        return ans;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countAtMost(nums, upper) - countAtMost(nums, lower - 1);
    }
}
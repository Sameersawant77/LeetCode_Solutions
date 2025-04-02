class Solution {
    public long maximumTripletValue(int[] nums) {
    int n = nums.length;
    long maxValue = 0;
    
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                long value = (long)(nums[i] - nums[j]) * nums[k];
                maxValue = Math.max(maxValue, value);
            }
        }
    }
    
    return maxValue;
}
}
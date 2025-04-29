class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length, left = 0, max = Arrays.stream(nums).max().getAsInt(), maxCount = 0;
        long res = 0;
        for(int right=0;right<n;right++){
            if(nums[right]==max) maxCount++;
            while(maxCount>=k && left<=right){
                res += n-right;
                if(nums[left]==max) maxCount--;
                left++;
            }
        }
        return res;
    }
}
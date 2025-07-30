class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, n =nums.length, curr = 0, res = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        for(int i=0;i<n;i++){
            if(nums[i]==max) res = Math.max(res,++curr);
            else curr = 0;
        }
        return res;
    }
}
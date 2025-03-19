class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, res = 0;
        for(int i=0;i<=n-3;i++){
            if(nums[i]==0){
                nums[i] ^= 1;
                nums[i+1] ^= 1;
                nums[i+2] ^= 1;
                res++;
            }
        }
        if(nums[n-1]==0 || nums[n-2]==0) return -1;
        return res;
    }
}
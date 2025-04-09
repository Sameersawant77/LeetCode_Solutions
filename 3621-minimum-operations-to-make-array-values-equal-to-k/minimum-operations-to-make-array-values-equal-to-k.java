class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0]<k) return -1;
        int res = nums[0]==k ? 0 : 1;
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=prev){
                res++;
                prev = nums[i];
            }
        }
        return res;
    }
}
class Solution {
    public int maximumDifference(int[] nums) {
        int res = -1, min = nums[0];
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(num-min>0)
                res = Math.max(res,num-min);
            min = Math.min(min,num);
        }
        return res;
    }
}
class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0, max = 0, maxDiff = 0;
        for(int num:nums){
            res = Math.max(res,num*maxDiff);
            max = Math.max(max,num);
            maxDiff = Math.max(maxDiff,max-num);
        }
        return res;
    }
}
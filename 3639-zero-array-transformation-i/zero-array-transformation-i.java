class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] lineBreak = new int[n+1];
        for(int[] query : queries){
            lineBreak[query[0]]++;
            lineBreak[query[1]+1]--;
        }
        int count = 0;
        for(int i=0;i<n;i++){
            count += lineBreak[i];
            if(nums[i]>count) return false;
        }
        return true;
    }
}
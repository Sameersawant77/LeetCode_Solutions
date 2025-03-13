class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] freq = new int[n];
        for(int[] query : queries){
            freq[query[0]]++;
            if(query[1]+1<n) freq[query[1]+1]--;
        }
        int curFreq = 0;
        for(int i=0;i<n;i++){
            curFreq += freq[i];
            if(curFreq<nums[i]) return false;
        }
        return true;
    }
}
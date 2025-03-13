class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int sum = 0, n = nums.length, k = 0;
        int[] prefixSum = new int[n+1];
        for(int i=0;i<nums.length;i++){
            while(sum+prefixSum[i]<nums[i]){
                if(k==queries.length) return -1;
                int left = queries[k][0];
                int right = queries[k][1];
                int val = queries[k][2];
                if(i<=right){
                    prefixSum[Math.max(i,left)]+=val;
                    prefixSum[right+1]-=val;
                }
                k++;
            }
            sum += prefixSum[i];
        }
        return k;
    }
}
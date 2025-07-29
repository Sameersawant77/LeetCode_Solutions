class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n], lastSeen = new int[30];
        for(int i=n-1;i>=0;i--){
            res[i] = 1;
            for(int j=0;j<30;j++){
                if((nums[i] & (1<<j)) > 0)
                    lastSeen[j] = i;
                res[i] = Math.max(res[i],lastSeen[j] - i + 1);
            }
        }
        return res;
    }
}
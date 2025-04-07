class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if((sum&1)==1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int num : nums){
            for(int i=sum;i>0;i--){
                if(i>=num){
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }
        return dp[sum];
    }
}
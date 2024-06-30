//You are given an integer array nums and a positive integer k.
//A
//subsequence
// sub of nums with length x is called valid if it satisfies:
//
//(sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k.
//Return the length of the longest valid subsequence of nums.

public class _3202_find_max_sub_seq_II {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int max = 0;
        for(int num:nums){
            for(int j=0;j<k;j++){
                dp[num%k][j] = dp[j][num%k] + 1;
                max = Math.max(max,dp[num%k][j]);
            }
        }
        return max;
    }
}

//Given an integer array nums, find the
//subarray
// with the largest sum, and return its sum.

public class kadanes_algorithm_53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }
}

// long maxi = Long.MIN_VALUE; // maximum sum
//        long sum = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            sum += arr[i];
//
//            if (sum > maxi) {
//                maxi = sum;
//            }
//
//            // If sum < 0: discard the sum calculated
//            if (sum < 0) {
//                sum = 0;
//            }
//        }

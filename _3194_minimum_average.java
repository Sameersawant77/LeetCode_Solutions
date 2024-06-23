//You have an array of floating point numbers averages which is initially empty. You are given an array nums of n integers where n is even.
//
//You repeat the following procedure n / 2 times:
//
//Remove the smallest element, minElement, and the largest element maxElement, from nums.
//Add (minElement + maxElement) / 2 to averages.
//Return the minimum element in averages.
//
//
//
//Example 1:
//
//Input: nums = [7,8,3,4,15,13,4,1]
//
//Output: 5.5

import java.util.Arrays;

public class _3194_minimum_average {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        double min_average = (nums[0]+nums[n])/2.0;
        for(int i=0;i<=n/2;i++){
            double average = (nums[i]+nums[n-i])/2.0;
            min_average = Math.min(min_average,average);
        }
        return min_average;
    }
}

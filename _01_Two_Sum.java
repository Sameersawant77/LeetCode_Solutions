// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.

import java.util.Arrays;

public class _01_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1, sum = 0;
        while(left<right){
            sum = nums[left] + nums[right];
            if(sum==target){
                return new int[] { left, right };
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return new int[] { -1, -1 };
    }
}

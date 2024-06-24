//Given an integer array nums, find a
//subarray
// that has the largest product, and return the product.
//
//The test cases are generated so that the answer will fit in a 32-bit integer.
//
//
//
//Example 1:
//
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
//Example 2:
//
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

public class _152_max_product_subarray {
    public int maxProduct(int[] nums) {
        double max = nums[0];
        double l = 1, r = 1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            l = (l==0 ? 1 : l) * nums[i];
            r = (r==0 ? 1 : r) * nums[n-1-i];
            max = Math.max(max,Math.max(l,r));
        }
        return (int)max;

    }
}

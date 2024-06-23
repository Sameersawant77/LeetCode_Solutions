//You are given an integer array nums with length n.
//
//The cost of a
//subarray
// nums[l..r], where 0 <= l <= r < n, is defined as:
//
//cost(l, r) = nums[l] - nums[l + 1] + ... + nums[r] * (−1)r − l
//
//Your task is to split nums into subarrays such that the total cost of the subarrays is maximized, ensuring each element belongs to exactly one subarray.
//
//Formally, if nums is split into k subarrays, where k > 1, at indices i1, i2, ..., ik − 1, where 0 <= i1 < i2 < ... < ik - 1 < n - 1, then the total cost will be:
//
//cost(0, i1) + cost(i1 + 1, i2) + ... + cost(ik − 1 + 1, n − 1)
//
//Return an integer denoting the maximum total cost of the subarrays after splitting the array optimally.
//
//Note: If nums is not split into subarrays, i.e. k = 1, the total cost is simply cost(0, n - 1).
//
//
//
//Example 1:
//
//Input: nums = [1,-2,3,4]
//
//Output: 10
//
//Explanation:
//
//One way to maximize the total cost is by splitting [1, -2, 3, 4] into subarrays [1, -2, 3] and [4]. The total cost will be (1 + 2 + 3) + 4 = 10.
//
//Example 2:
//
//Input: nums = [1,-1,1,-1]
//
//Output: 4
//
//Explanation:
//
//One way to maximize the total cost is by splitting [1, -1, 1, -1] into subarrays [1, -1] and [1, -1]. The total cost will be (1 + 1) + (1 + 1) = 4.

public class _3196_max_total_cost {
    public long maximumTotalCost(int[] nums) {
        if (nums.length == 0) return 0;
        long addResult = nums[0];
        long subResult = nums[0];
        for(int i=1;i<nums.length;i++){
            long tempAdd = Math.max(addResult,subResult) + nums[i];
            long tempSub = addResult - nums[i];

            addResult = tempAdd;
            subResult = tempSub;
        }
        return Math.max(addResult,subResult);
    }
}

// we consider adding the element and subtracting th element in tempAdd and temSub. in tempAdd we check max if elements are added or subtracted plus nums[i] is subtracting or starting or new subarray. in tempsub we subtract from the added subarray cost

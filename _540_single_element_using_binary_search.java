//You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
//
//Return the single element that appears only once.
//
//Your solution must run in O(log n) time and O(1) space.
//
//
//
//Example 1:
//
//Input: nums = [1,1,2,3,3,4,4,8,8]
//Output: 2

public class _540_single_element_using_binary_search {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r){
            int m = l + (r-l)/2;
            if((m%2 == 0 && nums[m] == nums[m+1]) || (m%2 == 1 && nums[m] == nums[m-1])){ // pair found
                l = m + 1;
            }else{
                r = m;
            }
        }
        return nums[l];
    }
}

// observation: a pair of elements always has left element in even position and right element in odd position
// if pair found then the above observation is not broken in the left side array from mid so target lies in right
// else observation is broken so the target lies in left side of array

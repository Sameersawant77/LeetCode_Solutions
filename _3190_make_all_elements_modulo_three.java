//You are given an integer array nums. In one operation, you can add or subtract 1 from any element of nums.
//
//Return the minimum number of operations to make all elements of nums divisible by 3.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//
//Output: 3
//
//Explanation:
//
//All array elements can be made divisible by 3 using 3 operations:
//
//Subtract 1 from 1.
//Add 1 to 2.
//Subtract 1 from 4.

public class _3190_make_all_elements_modulo_three {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for(int num:nums){
            if(num%3 != 0){
                if((num-1) % 3 ==0 || (num+1) % 3 == 0){
                    count ++;
                }else{
                    return 0;
                }
            }
        }
        return count;
    }
}

//int remainder = num % 3;
//count += Math.min(remainder, 3 - remainder);

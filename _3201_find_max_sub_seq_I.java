//You are given an integer array nums.
//A
//subsequence
// sub of nums with length x is called valid if it satisfies:
//
//(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
//Return the length of the longest valid subsequence of nums.
//
//A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.


public class _3201_find_max_sub_seq_I {
    public int maximumLength(int[] nums) {
        int even = 0, odd = 0, alternate = 0, parity = nums[0]%2;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0 ){
                even++;
            }else if(nums[i]%2==1){
                odd++;
            }
            if(nums[i]%2 == parity){
                alternate++;
                parity = parity ^ 1;
            }
        }
        return Math.max(alternate,Math.max(even,odd));
    }
}

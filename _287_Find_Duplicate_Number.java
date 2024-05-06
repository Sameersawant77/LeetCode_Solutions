// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
//
//You must solve the problem without modifying the array nums and uses only constant extra space.

public class _287_Find_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        int i = 0;

        while(i<nums.length){

            if(nums[i]!=i+1){
                int correct = nums[i]-1;
                if(nums[i] != nums[correct]){
                    swap(nums,i,correct);
                }else{
                    return nums[i];
                }
            }else{
                i++;
            }
        }

        return -1;
    }

    public void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

// Cyclic Sort
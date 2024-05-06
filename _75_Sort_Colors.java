// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.

public class _75_Sort_Colors {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, i = 0;
        while(i<=r){
            if(nums[i]==0){
                nums[i] = nums[l];
                nums[l] = 0;
                l++;
            }
            if(nums[i]==2){
                nums[i] = nums[r];
                nums[r] = 2;
                r--;
                i--;
            }
            i++;
        }
    }
}

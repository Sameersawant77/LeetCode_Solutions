
// Given a binary array nums, return the maximum number of consecutive 1's in the array.
public class _485_Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                result = Math.max(result,count);
            }else{
                count = 0;
            }
        }
        return result;
    }
}

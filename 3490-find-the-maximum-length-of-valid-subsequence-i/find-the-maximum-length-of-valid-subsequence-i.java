class Solution {
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
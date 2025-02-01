class Solution {
    public boolean isArraySpecial(int[] nums) {
        int xor = (nums[0]&1)==1 ? 0 : 1;
        for(int i=1;i<nums.length;i++){
            if(((nums[i]&1)^xor)>0) return false;
            xor ^= 1;
        }
        return true;
    }
}
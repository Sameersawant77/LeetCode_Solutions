class Solution {
    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for(int num : nums){
            int count = 0;
            while(num>0){
                count++;
                num /= 10;
            }
            if((count&1)==0) evenCount++;
        }
        return evenCount;
    }
}
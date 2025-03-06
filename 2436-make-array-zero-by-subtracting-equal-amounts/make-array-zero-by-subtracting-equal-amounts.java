class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int sub = 0,cnt = 0;
        for(int num : nums){
            num-=sub;
            if(num>0){
                sub+=num;
                cnt++;
            }
        }
        return cnt;
    }
}
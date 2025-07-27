class Solution {
    public int countHillValley(int[] nums) {
        int res = 0, prev = nums[0], i = 1, n = nums.length;
        while(i<n){
            int num = nums[i++];
            while(i<n && nums[i]==num){
                i++;
            }
            if(i>=n) break;
            if(num > prev && num > nums[i]){
                res++; // Hill: previous < current > next
            } else if(num < prev && num < nums[i]){
                res++; // Valley: previous > current < next
            }
            prev = num;
        }
        return res;
    }
}
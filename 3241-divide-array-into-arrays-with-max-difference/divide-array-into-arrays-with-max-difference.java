class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, index = 0;
        int[][] res = new int[n/3][3];
        for(int i=0;i<n;i+=3){
            if(nums[i+1]-nums[i]>k || nums[i+2]-nums[i]>k) return new int[0][0];
            res[index][0] = nums[i];
            res[index][1] = nums[i+1];
            res[index][2] = nums[i+2];
            index++;
        }
        return res;
    }
}
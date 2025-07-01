class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Integer[] sortedIndex = new Integer[n];
        for(int i=0;i<n;i++){
            sortedIndex[i] = i;
        }
        Arrays.sort(sortedIndex,(a,b)->nums[b]-nums[a]);
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = sortedIndex[i];
        }
        Arrays.sort(res);
        for(int i=0;i<k;i++){
            res[i] = nums[res[i]];
        }
        return res;
    }
}
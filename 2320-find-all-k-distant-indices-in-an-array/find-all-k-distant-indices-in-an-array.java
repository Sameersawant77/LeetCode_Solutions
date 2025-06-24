class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int lastAdded = -1, n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]==key){
                for(int j=Math.max(0,i-k);j<=Math.min(n-1,i+k);j++){
                    if(j>lastAdded){
                        res.add(j);
                        lastAdded = j;
                    }
                }
            }
        }
        return res;
    }
}
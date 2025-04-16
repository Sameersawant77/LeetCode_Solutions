class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long res = 0;
        int left = 0;
        long pairs = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int count = freq.getOrDefault(val, 0);
            
            pairs += count;
            freq.put(val, count + 1);

            while (pairs >= k) {
                res += nums.length - right;  
                int leftVal = nums[left];
                int leftCount = freq.get(leftVal);
                
                pairs -= (leftCount - 1);
                freq.put(leftVal, leftCount - 1);
                left++;
            }
        }

        return res;
    }
}

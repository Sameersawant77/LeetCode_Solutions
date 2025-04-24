class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int distinct = set.size();
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0, res = 0, n = nums.length;
        for(int right=0;right<n;right++){
            int num = nums[right];
            map.put(num,map.getOrDefault(num,0)+1);
            while(map.size()==distinct && left<=right){
                res += n - right;
                num = nums[left];
                map.put(num,map.get(num)-1);
                if(map.get(num)==0) map.remove(num);
                left++;
            }
        }
        return res;
    }
}
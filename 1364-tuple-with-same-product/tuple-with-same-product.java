class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> freq = new HashMap<>();
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int num = nums[i]*nums[j];
                freq.put(num,freq.getOrDefault(num,0)+1);
            }
        }
        for(int value : freq.values()){
            if(value>=2) res += value * (value-1) *4;
        }
        return res;
    }
}
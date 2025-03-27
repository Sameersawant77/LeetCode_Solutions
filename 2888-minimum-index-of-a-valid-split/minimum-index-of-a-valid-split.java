class Solution {
    public int minimumIndex(List<Integer> nums) {
        int dominant = 0, count = 0, n = nums.size();
        for(int num:nums){
            if(count==0) dominant = num;
            if(num==dominant) count++;
            else count--;
        }
        count = 0;
        for(int num:nums){
            if(num==dominant) count++;
        }
        if(count<=(n>>1)) return -1;
        int currentCount = 0;
        for(int i=0;i<n;i++){
            int num = nums.get(i);
            if(num==dominant) {
                currentCount++;
                count--;
            }
            if(currentCount>((i+1)>>1) && count>((n-i-1)>>1)) return i;
        }
        return -1;
    }
}
class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        int dominant = 0, maxCount = 0, n = nums.size();
        for(int i=0;i<n;i++){
            int num = nums.get(i);
            freq.put(num,freq.getOrDefault(num,0)+1);
            if(freq.get(num)>maxCount){
                maxCount = freq.get(num);
                dominant = num;
            }
        }
        if(maxCount<n/2) return -1;
        int currentCount = 0;
        for(int i=0;i<n-1;i++){
            int num = nums.get(i);
            if(num==dominant){
                currentCount++;
                maxCount--;
            } 
            if (currentCount > (i + 1) / 2 && maxCount > (n - i - 1) / 2) {
                return i;
            }
        }
        return -1;
    }
}
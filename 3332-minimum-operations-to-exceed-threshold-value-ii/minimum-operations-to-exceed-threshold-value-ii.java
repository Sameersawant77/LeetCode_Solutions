class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add((long)nums[i]);
        }
        while(pq.size()>=2 && pq.peek()<k){
            long num1 = pq.remove();
            long num2 = pq.remove();
            pq.offer(num1 * 2 + num2);
            count++;
        }
        return pq.peek() >= k ? count : -1;
    }
}
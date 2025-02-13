class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer((long)nums[i]);
        }
        while(pq.size()>=2 && pq.peek()<k){
            long num1 = pq.poll();
            long num2 = pq.poll();
            long op = (num1 * 2) + num2;
            pq.offer(op);
            count++;
        }
        return pq.peek() >= k ? count : -1;
    }
}
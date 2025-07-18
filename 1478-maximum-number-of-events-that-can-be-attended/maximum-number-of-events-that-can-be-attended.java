class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = 0, index = 0, n = events.length, canAttend = 0;
        while(!pq.isEmpty() || index<n){
            if(pq.isEmpty()){
                day = events[index][0];
            }
            while(index<n && events[index][0]<=day){
                pq.offer(events[index][1]);
                index++;
            }
            pq.poll();
            canAttend++;
            day++;
            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
        }
        return canAttend;
    }
}
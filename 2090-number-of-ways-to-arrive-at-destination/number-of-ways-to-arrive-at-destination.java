class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] road: roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((pair1,pair2)->Long.compare(pair1.distance,pair2.distance));

        long[] dist = new long[n];
        int[] ways = new int[n];
        int mod = (int)(1e9 + 7);

        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            int node = pq.peek().next;
            long dis = pq.peek().distance;
            pq.remove();
            for(Pair it : adj.get(node)){
                int adjNode = it.next;
                long edw = it.distance;

                if(dis + edw < dist[adjNode]){
                    dist[adjNode] = dis + edw;
                    pq.add(new Pair(adjNode,dis + edw));
                    ways[adjNode] = ways[node];
                }else if(dis + edw == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return (int) (ways[n-1] % mod);
    }
}

class Pair{
    int next;
    long distance;

    Pair(int next, long distance){
        this.next = next;
        this.distance = distance;
    }
}
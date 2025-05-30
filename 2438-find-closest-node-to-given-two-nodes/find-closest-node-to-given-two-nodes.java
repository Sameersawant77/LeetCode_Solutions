class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length, res = -1, minDist = Integer.MAX_VALUE;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        dfs(node1,edges,dist1,visited1);
        dfs(node2,edges,dist2,visited2);
        for(int i=0;i<n;i++){
            if(visited1[i] && visited2[i] && minDist>Math.max(dist1[i],dist2[i])){
                minDist = Math.max(dist1[i], dist2[i]);
                res = i;
            }
        }
        return res;
    }
    private void dfs(int node, int[] edges, int[] dist, boolean[] visited){
        visited[node] = true;
        int nieghbour = edges[node];
        if(nieghbour!=-1 && !visited[nieghbour]){
            dist[nieghbour] = dist[node] + 1;
            dfs(nieghbour,edges,dist,visited);
        }
    }
}
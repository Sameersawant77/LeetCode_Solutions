class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length+1, m = edges2.length+1;
        List<Integer>[] adj1 = buildGraph(edges1,n);
        List<Integer>[] adj2 = buildGraph(edges2,m);
        int max2 = 0;
        for(int i=0;i<m;i++){
            max2 = Math.max(max2,dfs(adj2,i,-1,k-1));
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = dfs(adj1,i,-1,k) + max2;
        }
        return res;
    }
    private List[] buildGraph(int[][] edges, int n){
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++) adj[i] = new ArrayList<>();
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return adj;
    }
    private int dfs(List<Integer>[] graph, int node, int parent, int k){
        if(k<0) return 0;
        int count = 1;
        for(int adjacent : graph[node]){
            if(adjacent!=parent) count += dfs(graph,adjacent,node,k-1);
        }
        return count;
    }
}
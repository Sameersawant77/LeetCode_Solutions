class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] bobPath = new int[n];
        Arrays.fill(bobPath,-1);
        ArrayList<Integer> path = new ArrayList<>();
        fillBobPath(bob,-1,path,graph);

        for(int i=0;i<path.size();i++){
            bobPath[path.get(i)] = i;
        }
        return maxAliceScore(0,-1,0,bobPath,graph,0,amount);
    }
    private boolean fillBobPath(int node,int parentNode,ArrayList<Integer> path, ArrayList<Integer>[] graph){
        if(node==0) return true;
        for(int neighbourNode : graph[node]){
            if(neighbourNode!=parentNode){
                path.add(node);
                if(fillBobPath(neighbourNode,node,path,graph)) return true;
                path.remove(path.size()-1);
            }
        }
        return false;
    }
    private int maxAliceScore(int node, int parentNode, int curScore, int[] bobPath, ArrayList<Integer>[] graph, int timestamp, int[] amount){
    if(bobPath[node]==-1 || bobPath[node] > timestamp){
        curScore += amount[node];
    }
    else if(bobPath[node]==timestamp){
        curScore += amount[node]/2;
    }
    if(graph[node].size()==1 && node!=0) return curScore;
    int maxScore = Integer.MIN_VALUE;
    for(int neighbourNode : graph[node]){
        if(neighbourNode!=parentNode){
            maxScore = Math.max(maxScore, maxAliceScore(neighbourNode, node, curScore, bobPath, graph, timestamp + 1, amount));
        }
    }
    return maxScore;
    }
}
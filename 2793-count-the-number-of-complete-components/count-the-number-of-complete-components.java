import java.util.*;

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            adj.get(nodeA).add(nodeB);
            adj.get(nodeB).add(nodeA);
        }

        int[] visited = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]==0) {
                Set<Integer> component = new HashSet<>();
                dfs(i, component, visited, adj);
                if (isCompleteComponent(component,adj)) count++;
            }
        }
        return count;
    }

    private void dfs(int node, Set<Integer> component, int[] visited, List<List<Integer>> adj) {
        component.add(node);
        visited[node]=1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor]==0) {
                dfs(neighbor, component, visited, adj);
            }
        }
    }

    private boolean isCompleteComponent(Set<Integer> component, List<List<Integer>> adj) {
        for (int node : component) {
            if (adj.get(node).size() != component.size() - 1) {
                return false;
            }
        }
        return true;
    }
}
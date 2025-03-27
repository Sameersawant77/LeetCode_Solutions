class Solution {
    public int numIslands(char[][] grid) {
        int res = 0, n = grid.length, m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i-1,j,n,m);
        dfs(grid,i+1,j,n,m);
        dfs(grid,i,j-1,n,m);
        dfs(grid,i,j+1,n,m);
    }
}
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int mn = m*n, res = 0, index = 0;
        int[] sorted = new int[mn];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sorted[index++] = grid[i][j];
            }
        }
        Arrays.sort(sorted);
        int mid = mn/2;
        int median = sorted[mid];
        for(int num : sorted){
            if(Math.abs(median-num)%x!=0){
                return -1;
            }
            res += Math.abs(median-num)/x;
        }
        return res;
    }
}
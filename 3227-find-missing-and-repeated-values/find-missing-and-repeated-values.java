class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int n = grid.length;
        int[] res = new int[2];
        for(int i=1;i<=n*n;i++){
            set.add(i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num = grid[i][j];
                if(!set.contains(num)) res[0] = num;
                else set.remove(num);
            }
        }
        res[1] = set.stream().findFirst().orElse(0);
        return res;
    }
}
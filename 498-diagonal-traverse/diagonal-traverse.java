class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0, j = 0, m = mat.length, n = mat[0].length, index = 0;
        int[] res = new int[m * n];
        boolean up = true; 
        while (index < m * n) {
            res[index++] = mat[i][j];
            
            if (up) {
                if (i == 0 && j < n - 1) {
                    j++;
                    up = false;
                } else if (j == n - 1) {
                    i++;
                    up = false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (j == 0 && i < m - 1) {
                    i++;
                    up = true;
                } else if (i == m - 1) {
                    j++;
                    up = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j] = smoothen(img,i,j,m,n);
            }
        }
        return res;
    }
    public int smoothen(int[][] img,int i, int j, int m, int n){
        int sum = 0, count = 0;

        int top = Math.max(0, i - 1);
        int bottom = Math.min(m, i + 2);
        int left = Math.max(0, j - 1);
        int right = Math.min(n, j + 2);

        for (int row = top; row < bottom; row++) {
            for (int col = left; col < right; col++) {
                sum += img[row][col];
                count ++;
            }
        }
        return sum/count;
    }
}
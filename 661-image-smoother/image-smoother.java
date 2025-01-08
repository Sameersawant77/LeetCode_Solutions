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
    public int smoothen(int[][] img,int a, int b, int m, int n){
        int sum = 0, count = 0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int ia = a + i;
                int jb = b + j;
                if(ia < 0 || ia >= m || jb < 0 || jb >= n) continue;
                sum += img[ia][jb];
                count++;
            }
        }
        return sum/count;
    }
}
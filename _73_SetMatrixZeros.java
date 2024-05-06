//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//
//You must do it in place.

public class _73_SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        boolean isRow0=false, isCol0=false;

        for(int j=0;j<n;j++){
            if(matrix[0][j]==0)
                isRow0=true;
        }

        for(int i=0;i<m;i++){
            if(matrix[i][0]==0)
                isCol0=true;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }

        if(isRow0){
            for(int j=0;j<n;j++)
                matrix[0][j]=0;
        }

        if(isCol0){
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }
    }
}

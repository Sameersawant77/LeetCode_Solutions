import java.util.ArrayList;
import java.util.List;

//Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
//
//A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

public class _1380_Lucky_number_in_matrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<matrix.length;i++){
            int minColIndex = minInRow(matrix,i);
            int candidate = matrix[i][minColIndex];

            if(maxInCol(matrix,minColIndex,candidate)){
                res.add(candidate);
            }
        }
        return res;
    }
    private static int minInRow(int[][] matrix,int row){
        int minValue = matrix[row][0], minColIndex = 0;
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[row][j] < minValue){
                minValue = matrix[row][j];
                minColIndex = j;
            }
        }
        return minColIndex;
    }
    private static boolean maxInCol(int[][] matrix,int minColIndex,int candidate){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][minColIndex]>candidate) return false;
        }
        return true;
    }
}

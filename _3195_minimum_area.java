//You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area, such that all the 1's in grid lie inside this rectangle.
//
//Return the minimum possible area of the rectangle.
//
//
//
//Example 1:
//
//Input: grid = [[0,1,0],[1,0,1]]
//
//Output: 6
//
//Example 2:
//
//Input: grid = [[0,0],[1,0]]
//
//Output: 1

public class _3195_minimum_area {
    public int minimumArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int top = n, bottom = -1, left = m, right = -1;
        boolean oneFound = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    oneFound = true;
                    top = Math.min(top,i);
                    bottom = Math.max(bottom,i);
                    left = Math.min(left,j);
                    right = Math.max(right,j);
                }
            }
        }

        if(!oneFound) return 0;

        int height = bottom - top + 1;
        int length = right - left + 1;

        return height * length;
    }
}

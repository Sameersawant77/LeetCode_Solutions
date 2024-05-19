// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

import java.util.ArrayList;
import java.util.List;

public class _119_Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            res.add(1);
            for(int j= i-1; j>0; j--){
                res.set(j,res.get(j-1)+res.get(j));
            }
        }
        return res;
    }
}

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

import java.util.Arrays;
import java.util.LinkedList;

public class _56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0],i2[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] i : intervals){
            if(!merged.isEmpty() && merged.getLast()[1]>=i[0]){
                merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
            }else{
                merged.add(i);
            }
        }
        return merged.toArray(new int[0][]);
    }
}

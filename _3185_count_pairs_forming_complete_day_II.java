//Given an integer array hours representing times in hours, return an integer denoting the number of pairs i, j where i < j and hours[i] + hours[j] forms a complete day.
//
//A complete day is defined as a time duration that is an exact multiple of 24 hours.
//
//For example, 1 day is 24 hours, 2 days is 48 hours, 3 days is 72 hours, and so on.

import java.util.HashMap;

public class _3185_count_pairs_forming_complete_day_II {
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Integer,Integer> map = new HashMap<>();
        long count = 0;
        for(int i=0;i<hours.length;i++){
            int rem = hours[i] % 24;
            int complement = (24 - rem) % 24;
            if(map.containsKey(complement)){
                count += map.get(complement);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}

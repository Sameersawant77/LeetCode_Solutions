//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]

import java.util.Arrays;

public class _350_intersection_of_two_arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hash = new int[1001];
        int[] hash2 = new int[1001];

        for(int num:nums1){
            hash[num]++;
        }

        int index = 0;
        for(int num: nums2){
            if(hash[num]>0){
                hash2[index] = num;
                hash[num]--;
                index++;
            }
        }

        return Arrays.copyOfRange(hash2,0,index);
    }
}

//public int[] intersect(int[] nums1, int[] nums2) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int num:nums1){
//            map.put(num,map.getOrDefault(num,0)+1);
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int num:nums2){
//            if(map.get(num)!=null && map.get(num)>0){
//                list.add(num);
//                map.put(num,map.get(num)-1);
//            }
//        }
//        int[] ans = new int[list.size()];
//        for(int i=0;i<list.size();i++){
//            ans[i] = list.get(i);
//        }
//        return ans;
//    }

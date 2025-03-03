class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> lesserThanPivot = new ArrayList<>();
        ArrayList<Integer> greaterThanPivot = new ArrayList<>();
        int pivotCount = 0;
        for(int num:nums){
            if(num<pivot) lesserThanPivot.add(num);
            else if(num>pivot) greaterThanPivot.add(num);
            else pivotCount++;
        }
        int[] res = new int[nums.length];
        int index = 0;
        for(int i=0;i<lesserThanPivot.size();i++){
            res[index++] = lesserThanPivot.get(i);
        }
        while(pivotCount-->0) res[index++] = pivot;
        for(int i=0;i<greaterThanPivot.size();i++){
            res[index++] = greaterThanPivot.get(i);
        }
        return res;
    }
}
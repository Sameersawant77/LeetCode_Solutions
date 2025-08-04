class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0;
        Map<Integer,Integer> fruitMap = new HashMap<>();
        for(int l=0,r=0;r<fruits.length;r++){
            fruitMap.put(fruits[r],fruitMap.getOrDefault(fruits[r],0)+1);
            while(fruitMap.size()>2){
                fruitMap.put(fruits[l],fruitMap.get(fruits[l])-1);
                fruitMap.remove(fruits[l],0);
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
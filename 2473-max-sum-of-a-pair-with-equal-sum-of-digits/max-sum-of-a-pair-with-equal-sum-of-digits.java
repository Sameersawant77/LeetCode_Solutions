class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,Integer> digitSumMap = new HashMap<>();
        int res = -1;
        for(int num : nums){
            int sum = getDigitSum(num);
            if(digitSumMap.containsKey(sum)){
                res = Math.max(res,num+digitSumMap.get(sum));
                digitSumMap.put(sum,Math.max(digitSumMap.get(sum),num));
            }else{
                digitSumMap.put(sum,num);
            }
        }
        return res;
    }
    public int getDigitSum(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
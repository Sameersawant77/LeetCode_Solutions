class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        int res = 2;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int a = arr[i], b = arr[j], len = 2;
                while(set.contains(a+b)){
                    b = a + b;
                    a = b - a;
                    len++;
                }
                res = Math.max(res,len);
            }
        }
        return res > 2 ? res : 0;
    }
}
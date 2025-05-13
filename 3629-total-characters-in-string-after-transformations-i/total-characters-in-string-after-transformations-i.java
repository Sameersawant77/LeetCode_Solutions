class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        for(int j=0;j<t;j++){
            int[] temp = new int[26];
            for(int i=0;i<26;i++){
                if(i==25){
                    temp[0] = (temp[0] + count[i]) % MOD;
                    temp[1] = (temp[1] + count[i]) % MOD;
                }
                else temp[i+1] = (temp[i+1] + count[i]) % MOD;
            }
            count = temp;
        }
        int res = 0;
        for(int c : count){
            res = (res + c) % MOD;
        }
        return res;
    }
}
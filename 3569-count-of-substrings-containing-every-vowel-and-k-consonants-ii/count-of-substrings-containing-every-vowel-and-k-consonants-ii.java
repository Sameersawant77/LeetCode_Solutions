class Solution {
    public long countOfSubstrings(String word, int k) {
        int[][] hash = new int[2][26];
        int currentK = 0, vowels = 0, extraLeft = 0;
        long res = 0;
        hash[0]['a'-'a'] = 1;
        hash[0]['e'-'a'] = 1;
        hash[0]['i'-'a'] = 1;
        hash[0]['o'-'a'] = 1;
        hash[0]['u'-'a'] = 1;
        for(int right=0,left=0; right<word.length();right++){
            char rightChar = word.charAt(right);
            if(hash[0][rightChar-'a']==1){
                if(++hash[1][rightChar-'a']==1) vowels++;
            }
            else currentK++;

            while(currentK>k){
                char leftChar = word.charAt(left);
                if(hash[0][leftChar-'a']==1){
                    if(--hash[1][leftChar-'a']==0) vowels--;
                }
                else currentK--;
                left++;
                extraLeft=0;
            }

            while (vowels == 5 && currentK == k && left < right && hash[0][word.charAt(left) - 'a'] == 1 && hash[1][word.charAt(left) - 'a'] > 1) {
    extraLeft++;
    hash[1][word.charAt(left) - 'a']--;
    left++;
}


            if(vowels==5 && currentK==k){
                res += (1 + extraLeft);
            }
        }
        return res;
    }
}
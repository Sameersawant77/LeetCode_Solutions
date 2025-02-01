class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(n<k) return false;
        if(n==k) return true;
        int[] freq = new int[26];
        int oddCount = 0;
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                if((freq[i]&1)==1) oddCount++;
            }
        }
        return oddCount<=k;
    }
}
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l=0, r=0, n = word2.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word1.length();i++){
            while(r<l && r<n){
                sb.append(word2.charAt(r++));
            }
            sb.append(word1.charAt(l++));
        }
        while(r<n) sb.append(word2.charAt(r++));
        return sb.toString();
    }
}
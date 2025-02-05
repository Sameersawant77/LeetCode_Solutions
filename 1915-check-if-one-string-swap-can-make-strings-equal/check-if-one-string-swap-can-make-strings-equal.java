class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int[] charHash = new int[26];
        int diff = 0;
        for(int i = 0;i<s1.length();i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 != c2){
                diff++;
                if(diff > 2) return false;
                charHash[c1 -'a']++;
                charHash[c2 -'a']--;
            }
        }
        for(int i=0;i<26;i++){
            if(charHash[i]!=0) return false;
        }
        return true;
    }
}
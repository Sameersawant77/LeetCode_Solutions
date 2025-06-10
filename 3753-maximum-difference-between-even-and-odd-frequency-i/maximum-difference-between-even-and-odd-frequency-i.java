class Solution {
    public int maxDifference(String s) {
        int[] hash = new int[26];
        int max = 0, min = s.length();
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(hash[i] > 0){
                if ((hash[i]&1)==1) {
                    max = Math.max(max, hash[i]);
                }
                if ((hash[i]&1)==0) {
                    min = Math.min(min, hash[i]);
                }
            }
        }
        return max - min;
    }
}
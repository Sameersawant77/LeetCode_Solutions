class Solution {
    public int numberOfSubstrings(String s) {
        int[] hash = new int[3];
        int res = 0, n = s.length();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            hash[s.charAt(right) - 'a']++;
            
            while (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                res += n - right;
                hash[s.charAt(left) - 'a']--;
                left++;
            }
        }
        
        return res;
    }
}
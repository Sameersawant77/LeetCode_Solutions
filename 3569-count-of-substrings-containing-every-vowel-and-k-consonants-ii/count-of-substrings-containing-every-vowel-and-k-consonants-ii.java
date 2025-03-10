class Solution {
    public long countOfSubstrings(String word, int k) {
        int[][] hash = new int[2][26];
        int currentK = 0, vowels = 0, extraLeft = 0;
        long res = 0;

        // Mark vowels in hash[0]
        hash[0]['a' - 'a'] = 1;
        hash[0]['e' - 'a'] = 1;
        hash[0]['i' - 'a'] = 1;
        hash[0]['o' - 'a'] = 1;
        hash[0]['u' - 'a'] = 1;

        for (int right = 0, left = 0; right < word.length(); right++) {
            char rightChar = word.charAt(right);

            // Check if the character is a vowel or a consonant
            if (hash[0][rightChar - 'a'] == 1) {
                if (++hash[1][rightChar - 'a'] == 1) vowels++;
            } else {
                currentK++;
            }

            // Shrink the window if consonants exceed k
            while (currentK > k) {
                char leftChar = word.charAt(left);
                if (hash[0][leftChar - 'a'] == 1) {
                    if (--hash[1][leftChar - 'a'] == 0) vowels--;
                } else {
                    currentK--;
                }
                left++;
                extraLeft = 0; // Reset extraLeft when left pointer moves
            }

            // Recalculate extraLeft by moving left forward over duplicate vowels
            while (vowels == 5 && currentK == k && left < right && hash[0][word.charAt(left) - 'a'] == 1 && hash[1][word.charAt(left) - 'a'] > 1) {
                extraLeft++;
                hash[1][word.charAt(left) - 'a']--;
                left++;
            }

            // If all vowels and k consonants exist, count substrings
            if (vowels == 5 && currentK == k) {
                res += (1 + extraLeft);
            }
        }
        return res;
    }
}

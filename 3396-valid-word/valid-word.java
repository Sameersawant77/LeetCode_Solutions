class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;  // Fix 1: Minimum length check

        int vowelCount = 0, consonantCount = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // Fix 2: Check if character is not alphanumeric
            if (!Character.isLetterOrDigit(c)) return false;

            if (Character.isLetter(c)) {  // Fix 3: Correct letter check
                if (isVowel(c)) vowelCount++;
                else consonantCount++;
            }
        }

        // Fix 4: Final validation condition
        return vowelCount >= 1 && consonantCount >= 1;
    }

    private boolean isVowel(char c) {
        // Fix 5: Case-insensitive vowel check
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

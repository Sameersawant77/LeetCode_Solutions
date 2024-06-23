//Given a string s which consists of lowercase or uppercase letters, return the length of the longest
//palindrome
// that can be built with those letters.
//
//Letters are case sensitive, for example, "Aa" is not considered a palindrome.
//
//
//
//Example 1:
//
//Input: s = "abccccdd"
//Output: 7
//Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
//Example 2:
//
//Input: s = "a"
//Output: 1
//Explanation: The longest palindrome that can be built is "a", whose length is 1.

import java.util.HashMap;

public class _409_Longest_Palindrome {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> charCount = new HashMap<>();
        int distinctChars = 0;
        for(char c: s.toCharArray()){
            charCount.put(c,charCount.getOrDefault(c,0)+1);
            if(charCount.get(c) % 2 == 0){
                distinctChars--;
            }else{
                distinctChars++;
            }
        }
        return distinctChars > 0 ? s.length()-distinctChars+1 : s.length();
    }
}

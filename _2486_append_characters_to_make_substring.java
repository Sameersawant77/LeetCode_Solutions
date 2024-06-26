//You are given two strings s and t consisting of only lowercase English letters.
//
//Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
//
//A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
//
//
//
//Example 1:
//
//Input: s = "coaching", t = "coding"
//Output: 4
//Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
//Now, t is a subsequence of s ("coachingding").
//It can be shown that appending any 3 characters to the end of s will never make t a subsequence.

public class _2486_append_characters_to_make_substring {
    public int appendCharacters(String s, String t) {
        int index = 0;
        char[] tarr = t.toCharArray();
        char[] sarr = s.toCharArray();
        for(int i=0;i<sarr.length && index<tarr.length;i++) {
            if(sarr[i]==tarr[index])    index++;
        }
        return t.length()-index;
    }
}

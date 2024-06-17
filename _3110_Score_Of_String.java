//You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
//
//Return the score of s.

public class _3110_Score_Of_String {
    public int scoreOfString(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;
        for(int i=1;i<s.length();i++){
            sum += Math.abs(arr[i-1] - arr[i]);
        }
        return sum;
    }
}

import java.util.Deque;
import java.util.LinkedList;

//You are given a string s that consists of lower case English letters and brackets.
//
//Reverse the strings in each pair of matching parentheses, starting from the innermost one.
//
//Your result should not contain any brackets.

//Input: s = "(ed(et(oc))el)"
//Output: "leetcode"
//Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

public class _1190_reverse_strings_between_paranthesis {
    public String reverseParentheses(String s) {
        int n = s.length();
        Deque<Integer> startIndexStack = new LinkedList<>();
        int[] index_pairs = new int[n];

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == '('){
                startIndexStack.push(i);
            }
            else if(c == ')'){
                int startIndex = startIndexStack.pop();
                index_pairs[startIndex] = i;
                index_pairs[i] = startIndex;
            }
        }

        StringBuilder res = new StringBuilder();
        int curr_index = 0;
        int curr_direction = 1;

        while(curr_index<n){
            char c = s.charAt(curr_index);
            if(c == '(' || c == ')'){
                curr_index = index_pairs[curr_index];
                curr_direction *= -1;
            }else{
                res.append(c);
            }
            curr_index += curr_direction;
        }

        return res.toString();
    }
}

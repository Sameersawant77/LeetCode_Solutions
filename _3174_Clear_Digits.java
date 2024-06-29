//You are given a string s.
//
//Your task is to remove all digits by doing this operation repeatedly:
//
//Delete the first digit and the closest non-digit character to its left.
//Return the resulting string after removing all digits.
//Input: s = "cb34"
//
//Output: ""
//
//Explanation:
//
//First, we apply the operation on s[2], and s becomes "c4".
//
//Then we apply the operation on s[1], and s becomes "".

public class _3174_Clear_Digits {
    public String clearDigits(String s) {
        StringBuilder ans =  new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                ans.deleteCharAt(ans.length()-1);
            }
            else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}

//Alternate Solution
//public String clearDigits(String s) {
//        Stack<Character> stack = new Stack<>();
//        char[] arr = s.toCharArray();
//        for(int i=0;i<arr.length;i++){
//            if(Character.isDigit(arr[i]) && !stack.empty()){
//                stack.pop();
//            }else{
//                stack.push(arr[i]);
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while(!stack.empty()){
//            sb.append(stack.pop());
//        }
//
//        return sb.reverse().toString();
//}

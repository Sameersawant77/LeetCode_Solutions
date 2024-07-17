//You are given a string s and two integers x and y. You can perform two types of operations any number of times.
//
//Remove substring "ab" and gain x points.
//For example, when removing "ab" from "cabxbae" it becomes "cxbae".
//Remove substring "ba" and gain y points.
//For example, when removing "ba" from "cabxbae" it becomes "cabxe".
//Return the maximum points you can gain after applying the above operations on s.

//Input: s = "cdbcbbaaabab", x = 4, y = 5
//Output: 19
//Explanation:
//- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
//- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
//- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
//- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
//Total score = 5 + 4 + 5 + 5 = 19.

public class _1717_max_score_remove_substring {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        int smaller = Math.min(x,y);
        int aCount = 0, bCount = 0;

        for(char c:s.toCharArray()){
            if(c > 'b'){
                res += Math.min(aCount,bCount) * smaller;
                aCount = 0;
                bCount = 0;
            }
            else if(c == 'b'){
                if(aCount > 0 && x > y){ // removing ab gains more points
                    res += x;
                    aCount--;
                }else{
                    bCount++;
                }
            }else{
                if(bCount > 0 && y > x){ // removing ba gains more points
                    res += y;
                    bCount--;
                }else{
                    aCount++;
                }
            }
        }
        res += Math.min(aCount,bCount) * smaller;
        return res;
    }
}

//You are given a string s and two integers x and y. You can perform two types of operations any number of times.
//
//Remove substring "ab" and gain x points.
//For example, when removing "ab" from "cabxbae" it becomes "cxbae".
//Remove substring "ba" and gain y points.
//For example, when removing "ba" from "cabxbae" it becomes "cabxe".
//Return the maximum points you can gain after applying the above operations on s.

public class _1717_max_score_after_removing_substring {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        StringBuilder sb = new StringBuilder(s);
        String top,bot;
        int topScore, botScore;
        if(x>y){
            top = "ab";
            topScore = x;
            bot = "ba";
            botScore = y;
        }else{
            top = "ba";
            topScore = y;
            bot = "ab";
            botScore = x;
        }

        res += scoreCount(sb,top) * topScore;
        res += scoreCount(sb,bot) * botScore;

        return res;
    }

    static int scoreCount(StringBuilder sb,String target){
        int writeIndex = 0, count = 0;
        for(int i=0;i<sb.length();i++){
            sb.setCharAt(writeIndex,sb.charAt(i));
            writeIndex++;
            if(writeIndex >= 2 && sb.charAt(writeIndex - 1) == target.charAt(1) && sb.charAt(writeIndex - 2) == target.charAt(0)){
                count++;
                writeIndex -= 2;
            }
        }
        sb.setLength(writeIndex);
        return count;
    }

}

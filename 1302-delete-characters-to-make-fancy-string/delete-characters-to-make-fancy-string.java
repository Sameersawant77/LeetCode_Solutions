class Solution {
    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(prev);
        int same = 0;
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(c==prev) same++;
            else{
                same = 0;
                prev = c;
            } 
            if(same<2) sb.append(c);
        }
        return sb.toString();
    }
}
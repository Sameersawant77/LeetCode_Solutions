class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        HashSet<Character> distinct;
        for(char c='a';c<='z';c++){
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);
            if(first!=-1 && last!=-1 && first<last){
                distinct = new HashSet<>();
                for(int i=first+1;i<last;i++){
                    distinct.add(s.charAt(i));
                }
                res += distinct.size();
            }
        }
        return res;
    }
}
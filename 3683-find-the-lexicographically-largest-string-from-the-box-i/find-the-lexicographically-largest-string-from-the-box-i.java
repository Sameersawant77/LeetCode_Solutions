class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        int n = word.length();
        String res = "";
        int len = n-numFriends+1;
        for(int i=0;i<n;i++){
            String temp = null;
            if(i+len<=n)
                temp = word.substring(i,i+len);
            else
                temp = word.substring(i);
            if(temp.compareTo(res)>0)
                res = temp;
        }
        return res;
    }
}
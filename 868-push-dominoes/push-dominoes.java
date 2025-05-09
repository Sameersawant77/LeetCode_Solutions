class Solution {
    public String pushDominoes(String dominoes) {
        String s = 'L'+dominoes+'R';
        int prev = 0;
        StringBuilder res = new StringBuilder();
        for(int curr=1;curr<s.length();curr++){
            if(s.charAt(curr)=='.') continue;
            int span = curr - prev - 1;
            char c = s.charAt(curr), p = s.charAt(prev);
            if(prev>0) res.append(p);
            if(c==p){
                for(int i=0;i<span;i++)
                    res.append(p);
            }
            else if(p=='L'&&c=='R'){
                for(int i=0;i<span;i++)
                    res.append('.');
            }
            else{
                for (int i = 0; i < span / 2; ++i)
                    res.append('R');
                if ((span&1)==1)
                    res.append('.');
                for (int i = 0; i < span / 2; ++i)
                    res.append('L');
            }
            prev=curr;
        }
        return res.toString();
    }
}
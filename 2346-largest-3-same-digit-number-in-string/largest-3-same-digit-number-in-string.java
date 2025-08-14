class Solution {
    public String largestGoodInteger(String num) {
        int l = 0, sameCount = 1;
        String res = "";
        for(int r=1;r<num.length();r++){
            if(num.charAt(r)==num.charAt(r-1)){
                sameCount++;
            }else{
                sameCount=1;
                l = r;
            }
            if(sameCount>=3){
                String temp = num.substring(l,r+1);
                if(res.length()==0 || Integer.parseInt(temp)>Integer.parseInt(res)){
                    res = temp;
                }
                sameCount=1;
                l = r;
            }
        }
        return res;
    }
}
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0;
        int operations = 0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W') operations++; 
        }
        if(operations==0) return 0;
        int res = operations;
        for(int i=k;i<blocks.length();i++){
            if(blocks.charAt(l)=='W'){
                operations--;
            }
            l++;
            if(blocks.charAt(i)=='W'){
                operations++;
            }
            if(operations==0) return 0;
            res = Math.min(res,operations);
        }
        return res;
    }
}


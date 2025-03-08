class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0;
        int blackCount = 0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='B') blackCount++; 
        }
        if(blackCount==k) return 0;
        int minRequired = k - blackCount;
        for(int i=k;i<blocks.length();i++){
            if(blocks.charAt(l)=='B'){
                blackCount--;
            }
            l++;
            if(blocks.charAt(i)=='B'){
                blackCount++;
            }
            if(blackCount==k) return 0;
            minRequired = Math.min(minRequired,k-blackCount);
        }
        return minRequired;
    }
}


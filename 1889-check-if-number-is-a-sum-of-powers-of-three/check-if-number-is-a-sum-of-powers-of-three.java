class Solution {
    public boolean checkPowersOfThree(int n) {
        return backtrack(0,0,n);
    }
    public boolean backtrack(int i,int curSum,int n){
        if(curSum==n) return true;
        if(curSum>n || (int) Math.pow(3,i)>n) return false;
        if(backtrack(i+1,curSum+ (int) Math.pow(3,i),n)) return true;
        return backtrack(i+1,curSum,n);
    }
}
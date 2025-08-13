class Solution {
    int maxPowerOfThree = 1;
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        if(maxPowerOfThree==1) maxPowerOfThree = calculateMaxPower();
        return maxPowerOfThree%n==0;
    }
    private int calculateMaxPower(){
        int power = 1;
        while(power <= Integer.MAX_VALUE / 3){
            power *= 3;
        }
        return power;
    }
}
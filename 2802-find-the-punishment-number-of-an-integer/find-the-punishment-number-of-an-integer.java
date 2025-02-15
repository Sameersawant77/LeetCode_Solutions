class Solution {
    int[] pre = new int[1001];
    
    public Solution() {
        for (int i = 1; i <= 1000; i++) {
            int square = i * i;
            if (canPartition(square, 0, i)) {
                pre[i] = square;
            }
        }
    }
    
    private boolean canPartition(int num, int sum, int target) {
        if (num == 0) return sum == target;
        
        int remaining = num;
        int divisor = 1;
        
        while (remaining >= 10) {
            divisor *= 10;
            remaining /= 10;
        }
        
        remaining = num;
        while (divisor > 0) {
            int currentPart = remaining / divisor;
            if (sum + currentPart > target) return false;
            
            if (canPartition(remaining % divisor, sum + currentPart, target)) {
                return true;
            }
            
            divisor /= 10;
        }
        
        return false;
    }
    
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (pre[i] != 0) {
                sum += pre[i];
            }
        }
        return sum;
    }
}
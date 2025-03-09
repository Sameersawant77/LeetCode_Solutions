class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0, count = 1, n = colors.length;
        for(int i=0;i<n+k-2;i++){
            count = colors[i%n] != colors[(i+1)%n] ? count+1 : 1;
            res += count>=k ? 1 : 0;
        }
        return res;
    }
}
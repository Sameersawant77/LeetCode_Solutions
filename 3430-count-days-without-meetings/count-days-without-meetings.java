class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int count = meetings[0][0] - 1;
        int n = meetings.length;
        for(int i=1;i<n;i++){
            if(meetings[i][0]<=meetings[i-1][1]){
                if(meetings[i][1]<meetings[i-1][1]){
                    meetings[i][1]=meetings[i-1][1];
                }
            }
            else{
                count += meetings[i][0] - meetings[i-1][1] - 1;
            }
        }
        count += days - meetings[n-1][1];
        return count;
    }
}
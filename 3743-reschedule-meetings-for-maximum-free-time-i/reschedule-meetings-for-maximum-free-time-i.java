class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n+1];
        gaps[0] = startTime[0];
        gaps[n] = eventTime - endTime[n-1];
        for(int i=1;i<n;i++){
            gaps[i] = startTime[i] - endTime[i-1];
        }
        int window = 0;
        for(int i=0;i<=k;i++){
            window += gaps[i];
        }
        int res = window;
        for(int i=k+1;i<=n;i++){
            window += gaps[i] - gaps[i-(k+1)];
            res = Math.max(res,window);
        }
        return res;
    }
}
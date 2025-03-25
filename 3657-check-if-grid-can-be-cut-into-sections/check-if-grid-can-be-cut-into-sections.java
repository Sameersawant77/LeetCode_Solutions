class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int res = 0, N = rectangles.length;
        Arrays.sort(rectangles,(a,b)->Integer.compare(a[0], b[0]));
        int pre = rectangles[0][2];
        for(int i=0;i<N;i++){
            if(pre<=rectangles[i][0]) res++;
            pre = Math.max(pre,rectangles[i][2]);
        }
        if(res > 1) return true;

        res = 0;
        Arrays.sort(rectangles,(a,b)->Integer.compare(a[1], b[1]));
        pre = rectangles[0][3];
        for(int i=0;i<N;i++){
            if(pre<=rectangles[i][1]) res++;
            pre = Math.max(pre,rectangles[i][3]);
        }
        if(res > 1) return true;

        return false;
    }
}
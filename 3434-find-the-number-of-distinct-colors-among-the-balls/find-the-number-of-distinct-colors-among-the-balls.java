class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> balls = new HashMap<>(), colors = new HashMap<>();
        int n = queries.length, distinct = 0;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int ball = queries[i][0], color = queries[i][1];
            if(balls.containsKey(ball)){
                int c = balls.get(ball);
                int cnt = colors.get(c)-1;
                if(cnt==0){
                    colors.remove(c);
                    distinct--;
                } 
                else colors.put(c,cnt);
            }
            balls.put(ball,color);
            int cnt = colors.getOrDefault(color,0)+1;
            colors.put(color,cnt);
            if(cnt==1) distinct++;
            res[i] = distinct;
        }
        return res;
    }
}
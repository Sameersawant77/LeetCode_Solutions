class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> balls = new HashMap<>(), colors = new HashMap<>();
        int n = queries.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int ball = queries[i][0], color = queries[i][1];
            if(balls.containsKey(ball)){
                if(balls.get(ball)==color){
                    res[i] = colors.size();
                    continue;
                } 
                else if(colors.get(balls.get(ball))<=1){
                    colors.remove(balls.get(ball));
                } 
                else{
                    colors.put(balls.get(ball),colors.get(balls.get(ball))-1);
                }
                balls.put(ball,color);
                colors.put(color,colors.getOrDefault(color,0)+1);
            }
            else{
                balls.put(ball,color);
                colors.put(color,colors.getOrDefault(color,0)+1);
            }
            res[i] = colors.size();
        }
        return res;
    }
}
class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i){
            dfs(i,n,res);
        }
        return res;
    }
    private void dfs(int curr,int n,List<Integer> res){
        if(curr>n) return;
        else{
            res.add(curr);
            for(int i=0;i<10;++i){
                if(10*curr+i>n) return;
                dfs(10*curr+i,n,res);
            }
        }
    }
}
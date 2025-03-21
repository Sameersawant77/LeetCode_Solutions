class Solution {
    int NOT_VISITED = 0;
    int VISITING = 1;
    int VISITED = 2;
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,Integer> status = new HashMap<>();
        Map<String,List<String>> req = new HashMap<>();
        for (int i = 0; i < recipes.length; ++ i) {
            status.put(recipes[i], NOT_VISITED);
            req.put(recipes[i], ingredients.get(i));
        }
        for (String s: supplies) {
            status.put(s, VISITED);
        }
        List<String> res = new ArrayList<>();
        for(String recipe:recipes){
            dfs(recipe,status,req,res);
        }
        return res;
    }
    private boolean dfs(String recipe, Map<String,Integer> status, Map<String,List<String>> req, List<String> res){
        if(!status.containsKey(recipe)) return false;
        if(status.get(recipe)==VISITING) return false;
        if(status.get(recipe)==VISITED) return true;

        status.put(recipe,VISITING);
        for(String s:req.get(recipe)){
            if(!dfs(s,status,req,res)){
                return false;
            }
        }
        status.put(recipe, VISITED);
        res.add(recipe);
        
        return true;
    }
}
class Solution {
    public int numRabbits(int[] answers) {
        if(answers.length == 0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        
        for(int i : answers){
            if(i == 0 ){
                sum += 1;
                continue;
            }
            if(!map.containsKey(i)){
                map.put(i, 0);
                sum += (i + 1);
                
            }else{
                map.put(i, map.get(i) + 1);
                if(map.get(i) == i){ 
                    map.remove(i);
                }
            }
            
        }
        return sum;
    }
}
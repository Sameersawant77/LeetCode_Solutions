class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            hash[s.charAt(i)-'a'] = i;
        }
        int prev = -1, max = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            max = Math.max(max,hash[s.charAt(i)-'a']);
            if(max==i){
                res.add(max-prev);
                prev = max;
            }
        }
        return res;
    }
}
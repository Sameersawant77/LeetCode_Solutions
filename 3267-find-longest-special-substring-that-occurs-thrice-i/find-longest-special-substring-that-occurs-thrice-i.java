class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        Map<Map.Entry<Character,Integer>,Integer> substringCountMap = new HashMap<>();
        int count;
        for(int i=0;i<n;i++){
            count = 1;
            substringCountMap.put(Map.entry(s.charAt(i),count),
                substringCountMap.getOrDefault(Map.entry(s.charAt(i),count),0)+1);
            for (int j = i; j < n; j++) {
                if (j + 1 < n && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                    substringCountMap.put(Map.entry(s.charAt(i), count), substringCountMap.getOrDefault(Map.entry(s.charAt(i), count), 0) + 1);
                } else {
                    break;
                }
            }
        }
        int res = -1;
        for(Map.Entry<Map.Entry<Character,Integer>,Integer> entryMap:substringCountMap.entrySet()){
            if(entryMap.getValue()>=3){
                res = Math.max(res,entryMap.getKey().getValue());
            }
        }
        return res;
    }
}
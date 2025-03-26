class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] rank = new int[26][n];
        for(String vote : votes){
            for(int i=0;i<n;i++){
                rank[vote.charAt(i)-'A'][i]++;
            }
        }
        Character[] teams = new Character[n];
        for(int i=0;i<n;i++){
            teams[i] = votes[0].charAt(i);
        }
        Arrays.sort(teams,(a,b)->{
            int indexA = a - 'A';
            int indexB = b - 'A';
            for(int i=0;i<n;i++){
                if(rank[indexA][i]!=rank[indexB][i]){
                    return rank[indexB][i] - rank[indexA][i];
                }
            }
            return indexA - indexB;
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(teams[i]);
        }
        return sb.toString();
    }
}

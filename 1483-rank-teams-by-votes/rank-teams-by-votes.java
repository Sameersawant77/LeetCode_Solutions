class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        Node[] rank = new Node[26];
        for(int i=0;i<26;i++){
            rank[i] = new Node((char) (i + 'A'));
        }
        for(String vote : votes){
            for(int i=0;i<n;i++){
                rank[vote.charAt(i)-'A'].count[i]++;
            }
        }

        Arrays.sort(rank,(a,b)->{
            for(int i=0;i<26;i++){
                if(a.count[i]!=b.count[i]){
                    return b.count[i] - a.count[i];
                }
            }
            return a.ch - b.ch;
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(rank[i].ch);
        }
        return sb.toString();
    }
}

class Node{
    char ch;
    int[] count = new int[26];
    Node(char ch){
        this.ch = ch;
    }
}
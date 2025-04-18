class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        return RLE("1",n-1);
    }
    private String RLE(String str,int count){
        if(count==0) return str;
        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        int counter = 1;
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == prev) {
                counter++;
            } else {
                sb.append(counter).append(prev);
                prev = current;
                counter = 1;
            }
        }
        sb.append(counter).append(prev);
        return RLE(sb.toString(),count-1);
    }
}
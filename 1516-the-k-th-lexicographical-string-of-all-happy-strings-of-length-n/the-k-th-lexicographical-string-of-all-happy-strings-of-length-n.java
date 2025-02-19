class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        String res = "";
        char[] arr = new char[]{'a','b','c'};
        generatePerm(arr,n,res,list);
        if(list.size()>=k) return list.get(k-1);
        return res;
    }
    public void generatePerm(char[] arr,int n,String res, List<String> list){
        if(n==0){
            list.add(res);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(res=="" || res.charAt(res.length()-1)!=arr[i]){
                String perm = res + arr[i];
                generatePerm(arr,n-1,perm,list);
            }
        }
    }
}
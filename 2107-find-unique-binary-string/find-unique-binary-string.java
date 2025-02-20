class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] strArray = new char[n];
        for(int i=0;i<nums.length;i++){
            strArray[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }
        return new String(strArray);
    }
}
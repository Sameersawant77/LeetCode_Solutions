/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        maxPathHelper(root,res);
        return res[0];
    }
    private int maxPathHelper(TreeNode root, int[] res){
        if(root==null) return 0;
        int leftMax = Math.max(0,maxPathHelper(root.left,res));
        int rightMax = Math.max(0,maxPathHelper(root.right,res));
        res[0] = Math.max(res[0],root.val+leftMax+rightMax);
        return root.val + Math.max(leftMax,rightMax);
    }
}
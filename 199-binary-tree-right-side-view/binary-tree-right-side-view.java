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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root,result,0);
        return result;
    }
    private void rightView(TreeNode node, List<Integer> result, int depth){
        if(node==null) return;
        if(result.size()==depth) result.add(node.val);
        rightView(node.right,result,depth+1);
        rightView(node.left,result,depth+1);
    }
}
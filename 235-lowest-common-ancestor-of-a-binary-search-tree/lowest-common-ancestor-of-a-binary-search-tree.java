/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean isPSmall = p.val < q.val;
        return lowestCommonAncestorHelper(root, isPSmall ? p : q, isPSmall ? q : p);
    }
    private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode smaller, TreeNode larger){
        if(root==null || root==smaller || root==larger) return root;
        if(smaller.val<root.val && root.val<larger.val) return root;
        if(smaller.val<root.val && larger.val<root.val) return lowestCommonAncestorHelper(root.left,smaller,larger);
        if(smaller.val>root.val && larger.val>root.val) return lowestCommonAncestorHelper(root.right,smaller,larger);
        return root;
    }
}
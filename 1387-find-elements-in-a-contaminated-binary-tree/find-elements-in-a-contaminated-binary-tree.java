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
class FindElements {
    TreeNode treeNode;
    Set<Integer> values;

    public FindElements(TreeNode root) {
        treeNode = root;
        values = new HashSet<>();
        if (root != null) {
            root.val = 0;  
            values.add(0); 
            recoverTree(root);  
        }
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }

    private void recoverTree(TreeNode node) {
        if (node == null) return;
        
        // Recover left child
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            values.add(node.left.val);
            recoverTree(node.left);
        }
        
        // Recover right child
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            values.add(node.right.val);
            recoverTree(node.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
import java.util.*;

//Given the root of a binary tree, each node in the tree has a distinct value.
//
//After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
//
//Return the roots of the trees in the remaining forest. You may return the result in any order.

public class _1110_delete_nodes_return_forest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if(root==null) return res;

        HashSet<Integer> set = new HashSet<>();
        for(int n : to_delete){
            set.add(n);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr.left != null){
                queue.offer(curr.left);
                if(set.contains(curr.left.val)){
                    curr.left = null;
                }
            }

            if(curr.right != null){
                queue.offer(curr.right);
                if(set.contains(curr.right.val)){
                    curr.right = null;
                }
            }

            if(set.contains(curr.val)){
                if(curr.left != null){
                    res.add(curr.left);
                }
                if(curr.right != null){
                    res.add(curr.right);
                }
            }else if(res.isEmpty()){
                res.add(curr);
            }
        }
        return res;
    }
}

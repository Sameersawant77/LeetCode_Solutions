import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,
//
//If isLefti == 1, then childi is the left child of parenti.
//If isLefti == 0, then childi is the right child of parenti.
//Construct the binary tree described by descriptions and return its root.
//
//The test cases will be generated such that the binary tree is valid.
public class _2196_create_binary_tree_from_2d_array {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[] arr: descriptions){
            int parent = arr[0], child = arr[1], isLeft = arr[2];
            children.add(child);
            TreeNode node = map.getOrDefault(parent,new TreeNode(parent));
            if(isLeft == 1){
                node.left = map.getOrDefault(child,new TreeNode(child));
                map.put(child,node.left);
            }else{
                node.right = map.getOrDefault(child,new TreeNode(child));
                map.put(child,node.right);
            }
            map.put(parent,node);
        }

        int root = -1;
        for(int[] arr: descriptions){
            if(!children.contains(arr[0])){
                root = arr[0];
                break;
            }
        }

        return map.getOrDefault(root,null);
    }
}

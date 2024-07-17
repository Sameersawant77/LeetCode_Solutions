import java.util.ArrayList;
//You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.
//
//Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
//
//'L' means to go from a node to its left child node.
//'R' means to go from a node to its right child node.
//'U' means to go from a node to its parent node.
//Return the step-by-step directions of the shortest path from node s to node t.

public class _2096_direction_from_start_to_dest_binary_tree {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<String> pathToStartNode = new ArrayList<>();
        ArrayList<String> pathToDestNode = new ArrayList<>();
        pathFromRoot(root,startValue,pathToStartNode);
        pathFromRoot(root,destValue,pathToDestNode);

        int commonPathLen = 0;
        while(commonPathLen < pathToStartNode.size() &&
                commonPathLen < pathToDestNode.size() &&
                pathToStartNode.get(commonPathLen).equals(pathToDestNode.get(commonPathLen))
        ){
            commonPathLen++;
        }

        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<pathToStartNode.size() - commonPathLen; i++){
            res.add("U");
        }
        for(int i=commonPathLen;i<pathToDestNode.size();i++){
            res.add(pathToDestNode.get(i));
        }

        return String.join("",res);
    }
    private static boolean pathFromRoot(TreeNode curr,int target,ArrayList<String> pathToAppend){
        if(curr == null){
            return false;
        }

        if(curr.val == target){
            return true;
        }

        pathToAppend.add("L");
        if(pathFromRoot(curr.left,target,pathToAppend)){
            return true;
        }
        pathToAppend.remove(pathToAppend.size()-1);

        pathToAppend.add("R");
        if(pathFromRoot(curr.right,target,pathToAppend)){
            return true;
        }
        pathToAppend.remove(pathToAppend.size()-1);

        return false;
    }
}

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
    int getDepth(TreeNode root){ //it works as complete tree 
        int depth=0;
        while(root!=null){
            depth++;
            root=root.left;
        }
        return depth;
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        
        int leftDepth=getDepth(root.left);
        int rightDepth=getDepth(root.right);

        if(leftDepth==rightDepth){
            return (1 << leftDepth) + countNodes(root.right);
        }
        else{
            return (1<<rightDepth)+countNodes(root.left);
        }
    }
}
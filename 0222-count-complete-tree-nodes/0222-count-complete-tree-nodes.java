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
    int depth(TreeNode root){
        int depth=0;
        while(root!=null){
            root=root.left;
            depth++;
        }
        return depth;
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int leftHeight=depth(root.left);
        int rightHeight=depth(root.right);

        if(leftHeight==rightHeight){
            return (1<<leftHeight)+countNodes(root.right);
        }
        else{
            return (1<<rightHeight)+countNodes(root.left);
        }
    }
}
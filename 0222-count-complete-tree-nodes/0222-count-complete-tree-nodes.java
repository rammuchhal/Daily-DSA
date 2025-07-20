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
    public int preOrder(int count,TreeNode root){
        if(root==null) return count;
 
        count=preOrder(count,root.left);
        count=preOrder(count,root.right);
        count++;
        return count;
    }
    public int countNodes(TreeNode root) {
        int count=0;
        return preOrder(count,root);
    }
}
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
    public int inOrder(int count,TreeNode root){
        if(root==null) return count;

        count=inOrder(count,root.left);
        count++;
        count=inOrder(count,root.right);
        return count;
    }
    public int countNodes(TreeNode root) {
        int count=0;
        return inOrder(count,root);
    }
}
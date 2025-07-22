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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        
        if(root.left==root.right){
            return targetSum==root.val;
        }

        boolean leftTree=hasPathSum(root.left,targetSum-root.val);
        boolean rightTree=hasPathSum(root.right,targetSum-root.val);

        return leftTree || rightTree;
    }
}
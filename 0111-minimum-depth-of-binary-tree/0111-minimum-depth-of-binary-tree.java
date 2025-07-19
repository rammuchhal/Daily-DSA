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
    public int getMinDepth(int depth,TreeNode root){
        if(root==null) return Integer.MAX_VALUE;
        if(root.left==root.right){
            return depth+1;
        }

        depth++;
        int left=getMinDepth(depth,root.left);
        int right=getMinDepth(depth,root.right);
        return Math.min(left,right);
    }
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return getMinDepth(0,root);
    }
}
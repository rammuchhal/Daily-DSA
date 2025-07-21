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
    int height(TreeNode root){
        if(root==null) return 0;

        int left=height(root.left);
        int right=height(root.right);

        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        int case1=diameterOfBinaryTree(root.left);
        int case2=diameterOfBinaryTree(root.right);
        int case3=height(root.left)+height(root.right);

        return Math.max(case1,Math.max(case2,case3));
    }
}
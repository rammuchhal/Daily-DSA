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
    public int getDiameter(TreeNode root,int[] ans){
        if(root==null) return 0;

        int leftSubTree=getDiameter(root.left,ans);
        int rightSubTree=getDiameter(root.right,ans);

        if( (leftSubTree+rightSubTree)>ans[0] ){
            ans[0]=leftSubTree+rightSubTree;
        }
        return 1+Math.max(leftSubTree,rightSubTree);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans=new int[1];
        getDiameter(root,ans);
        return ans[0];
    }
}
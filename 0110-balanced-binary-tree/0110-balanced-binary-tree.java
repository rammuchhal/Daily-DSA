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
    public int getBalanced(TreeNode root,boolean[] ans){
        if(root==null) return 0;

        int left=getBalanced(root.left,ans);
        int right=getBalanced(root.right,ans);

        if(left==Integer.MAX_VALUE || right==Integer.MAX_VALUE) return Integer.MAX_VALUE;

        if(Math.abs(left-right)>1){
            ans[0]=false;
            return Integer.MAX_VALUE;
        }
        ans[0]=true;
        return 1+Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        boolean[] ans=new boolean[1];
        if(root==null) return true;
        if(getBalanced(root,ans)==Integer.MAX_VALUE) return false;
        return ans[0];
    }
}
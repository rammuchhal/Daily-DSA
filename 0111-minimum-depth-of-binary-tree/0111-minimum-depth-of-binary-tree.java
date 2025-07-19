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
    public int getMinDepth(Integer mini,int depth,TreeNode root){
        if(root==null) return mini;
        if(root.left==root.right){
            mini = Math.min(mini,depth+1);
            return mini;
        }

        depth++;
        mini=getMinDepth(mini,depth,root.left);
        mini=getMinDepth(mini,depth,root.right);
        return mini;
    }
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Integer mini=Integer.MAX_VALUE;
        int depth=0;

        return getMinDepth(mini,depth,root);
        // return mini;
    }
}
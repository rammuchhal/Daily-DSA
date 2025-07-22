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
    int getDiameter(TreeNode root,AtomicInteger ans){
        if(root==null) return 0;

        int left=getDiameter(root.left,ans);
        int right=getDiameter(root.right,ans);

        ans.set(Math.max(ans.get(),left+right));

        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger ans=new AtomicInteger(0);
        getDiameter(root,ans);
        return ans.get();
    }
}
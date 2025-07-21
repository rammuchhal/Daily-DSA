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
class Pair{
    int height;
    boolean isBalanced;
    Pair(int height,boolean isBalanced){
        this.height=height;
        this.isBalanced=isBalanced;
    }
}
class Solution {
    public Pair getAns(TreeNode root){
        if(root==null) return new Pair(0,true);

        Pair left=getAns(root.left);
        if(!left.isBalanced) return new Pair(0,false);

        Pair right=getAns(root.right);
        if(!right.isBalanced) return new Pair(0,false);

        int height=1+Math.max(left.height,right.height);
        boolean isBalanced=Math.abs(left.height-right.height)<=1;

        return new Pair(height,isBalanced);
    }
    public boolean isBalanced(TreeNode root) {
        return getAns(root).isBalanced;
    }
}
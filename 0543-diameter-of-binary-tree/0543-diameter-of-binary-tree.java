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
    Integer height;
    Integer diameter;
    public Pair(Integer height,Integer diameter){
        this.height=height;
        this.diameter=diameter;
    }
}
class Solution {
    public Pair getDiameter(TreeNode root){
        if(root==null) return new Pair(0,0);

        Pair left=getDiameter(root.left);
        Pair right=getDiameter(root.right);

        int height=1+Math.max(left.height,right.height);
        int diameter=Math.max(left.diameter,Math.max(right.diameter,left.height+right.height));

        return new Pair(height,diameter);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return getDiameter(root).diameter;
    }
}
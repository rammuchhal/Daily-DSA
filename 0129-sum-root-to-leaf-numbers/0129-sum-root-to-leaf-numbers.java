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
    int getSum(TreeNode root,StringBuilder s){
        if(root==null) return 0;
        s.append(root.val);

        int total=0;
        if(root.left==root.right){
            total+=Integer.parseInt(s.toString());
        }
        else{
           total+=getSum(root.left,s);
           total+=getSum(root.right,s);
        }

        s.deleteCharAt(s.length()-1);
        return total;
    }
    public int sumNumbers(TreeNode root) {
        return getSum(root,new StringBuilder());
    }
}
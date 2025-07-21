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
    int getSum(TreeNode root,int sum,StringBuilder s){
        if(root==null) return sum;
        s.append(root.val);

        if(root.left==root.right){
            String st=s.toString();
            int num=Integer.parseInt(st);
            sum+=num;
        }
        else{
            sum=getSum(root.left,sum,s);
            sum=getSum(root.right,sum,s);
        }

        s.deleteCharAt(s.length()-1);
        return sum;
    }
    public int sumNumbers(TreeNode root) {
        int sum=0;
        StringBuilder s=new StringBuilder("");
        return getSum(root,sum,s);
    }
}
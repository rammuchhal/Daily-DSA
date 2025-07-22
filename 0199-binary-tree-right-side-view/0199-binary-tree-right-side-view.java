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
    private void getRightView(TreeNode root,int lvl,List<Integer> ans){
        if(root==null) return;

        if(lvl==ans.size()) ans.add(root.val);
        getRightView(root.right,lvl+1,ans);
        getRightView(root.left,lvl+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        getRightView(root,0,ans);
        return ans;
    }
}
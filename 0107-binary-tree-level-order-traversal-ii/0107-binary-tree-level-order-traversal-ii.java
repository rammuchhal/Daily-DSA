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
    public void inOrder(List<List<Integer>> ans,TreeNode root,int level){
        if(root==null) return;

        if(ans.size()==level) ans.add(0,new ArrayList<>());
        inOrder(ans,root.left,level+1);
        ans.get(ans.size()-level-1).add(root.val);
        inOrder(ans,root.right,level+1);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        inOrder(ans,root,0);
        return ans;
    }
}
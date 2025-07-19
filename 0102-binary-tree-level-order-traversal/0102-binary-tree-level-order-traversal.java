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
    private List<List<Integer>> inOrder(TreeNode root,List<List<Integer>> ans,int level){
        if(root==null) return ans;
        
        if(ans.size()==level) ans.add(new ArrayList<>());
        ans=inOrder(root.left,ans,level+1);
        ans.get(level).add(root.val);
        ans=inOrder(root.right,ans,level+1);

        return ans;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level=0;
        List<List<Integer>> ans=new ArrayList<>();
        return inOrder(root,ans,level);
    }
}
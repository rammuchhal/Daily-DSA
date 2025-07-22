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
    void getPaths(TreeNode root,List<String> ans,StringBuilder sb){
        if(root==null) return;
        int len=sb.length();

        if(len!=0) sb.append("->");
        sb.append(root.val);

        if(root.left==root.right){
            ans.add(sb.toString());
        }
        else{
            getPaths(root.left,ans,sb);
            getPaths(root.right,ans,sb);
        }
        sb.setLength(len);
        return;

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        getPaths(root,ans,sb);
        return ans;
    }
}
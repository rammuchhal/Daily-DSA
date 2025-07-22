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
    List<List<Integer>> getPathSum(TreeNode root,List<List<Integer>> ans,ArrayList<Integer> arr,int targetSum){
        if(root==null) return ans;

        arr.add(root.val);
        if(root.left==root.right && root.val==targetSum){
            ans.add(new ArrayList<>(arr));
        }
        else{
            getPathSum(root.left,ans,arr,targetSum-root.val);
            getPathSum(root.right,ans,arr,targetSum-root.val);
        }
        arr.remove(arr.size()-1);
        return ans;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        return getPathSum(root,ans,arr,targetSum);
    }
}
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
    List<List<Integer>> getPathSum(List<List<Integer>> ans,
                                    ArrayList<Integer> path,TreeNode root,int sum){
        if(root==null) return ans;
        path.add(root.val);

        if(root.left==root.right && root.val==sum){
                ans.add(new ArrayList<>(path)); //path ka ref use horha h func me so
        }                                   //we passed a copy of path 
        else{
            getPathSum(ans,path,root.left,sum-root.val);
            getPathSum(ans,path,root.right,sum-root.val);
        }

        path.remove(path.size()-1);
        return ans;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();
        return getPathSum(ans,path,root,targetSum);
    }
}
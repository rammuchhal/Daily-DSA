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
        if(root.left==root.right){
            if(root.val==sum){
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return ans;
        }

        sum-=root.val;
        path.add(root.val);
        ans=getPathSum(ans,path,root.left,sum);

        ans=getPathSum(ans,path,root.right,sum);
        path.remove(path.size()-1);

        return ans;

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();
        return getPathSum(ans,path,root,targetSum);
    }
}
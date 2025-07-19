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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        TreeNode temp=root;

        while(temp!=null || !s.isEmpty()){
            if(temp!=null){
                ans.add(temp.val);
                s.push(temp);
                temp=temp.left;
            }
            else{
                temp=s.peek();
                s.pop();

                temp=temp.right;
            }
        }
        return ans;
    }
}
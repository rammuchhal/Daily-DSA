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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        TreeNode temp=root;

        while(temp!=null || !s.isEmpty()){
            while(temp!=null){
                s.push(temp);
                temp=temp.left;
            }
            temp=s.peek();
            s.pop();

            ans.add(temp.val);
            
            temp=temp.right;
        }
        return ans;
    }
}
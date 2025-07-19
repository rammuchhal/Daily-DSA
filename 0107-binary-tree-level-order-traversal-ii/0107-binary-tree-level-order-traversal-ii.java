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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();

        if(root==null) return ans;

        q.offer(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> temp=new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode node=q.peek();
                q.poll();
                temp.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            ans.add(0,temp);
        }
        return ans;
    }
}
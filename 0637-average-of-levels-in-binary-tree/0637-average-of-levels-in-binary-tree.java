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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null) return ans;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            Double avg=0.00;

            for(int i=0;i<size;i++){
                TreeNode node=q.peek();
                q.poll();
                avg+=node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            ans.add(avg/size);
        }
        return ans;
    }
}
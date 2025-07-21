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
    public int maxLevelSum(TreeNode root) {
        long maxSum=Integer.MIN_VALUE;
        int ans=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        int lvl=1;

        while(!q.isEmpty()){
            int size=q.size();
            long sum=0;

            for(int i=0;i<size;i++){
                TreeNode front=q.poll();
                sum+=front.val;
                if(front.left!=null) q.offer(front.left);
                if(front.right!=null) q.offer(front.right);
            }
            if(sum>maxSum){
                maxSum=sum;
                ans=lvl;
            }
            lvl++;
        }
        return ans;
    }
}
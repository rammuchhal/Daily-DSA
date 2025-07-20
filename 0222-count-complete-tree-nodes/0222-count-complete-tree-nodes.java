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
    public int preOrder(int count,TreeNode root){
        if(root==null) return count;
 
        count=preOrder(count,root.left);
        count=preOrder(count,root.right);
        count++;
        return count;
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int count=0;
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode front=q.peek();
            q.poll();

            count++;
            if(front.left!=null) q.offer(front.left);
            if(front.right!=null) q.offer(front.right);
        }

        return count;
    }
}
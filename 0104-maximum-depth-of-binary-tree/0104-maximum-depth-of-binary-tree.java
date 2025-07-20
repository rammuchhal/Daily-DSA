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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> temp=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode front=q.peek();
                temp.add(front.val);
                q.poll();
                if(front.left!=null) q.offer(front.left);
                if(front.right!=null) q.offer(front.right);
            }
            ans.add(temp);
        }
        return ans.size();
    }
}
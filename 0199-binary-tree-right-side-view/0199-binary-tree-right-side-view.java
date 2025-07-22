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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> rightView=new ArrayList<>();

        if(root==null) return rightView;
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            int lvlNode=0;

            for(int i=0;i<size;i++){
                TreeNode front=q.poll();
                lvlNode=front.val;
                if(front.left!=null) q.offer(front.left);
                if(front.right!=null) q.offer(front.right);
            }
            rightView.add(lvlNode);
        }
        return rightView;
    }
}
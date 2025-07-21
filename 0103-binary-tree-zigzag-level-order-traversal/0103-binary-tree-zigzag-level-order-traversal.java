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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzaglvl=new ArrayList<>();
        if(root==null) return zigzaglvl;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean isEven=true;

        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> temp=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode front=q.peek();
                q.poll();
                if(front.left!=null) q.offer(front.left);
                if(front.right!=null) q.offer(front.right);
                temp.add(front.val);
            }
            if(!isEven) Collections.reverse(temp);
            zigzaglvl.add(temp);
            isEven = !isEven;
        }
        return zigzaglvl;
    }
}
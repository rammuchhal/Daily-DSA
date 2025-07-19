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
    Double getAvg(ArrayList<Integer> lvl){
        Double avg=0.00;
        for(int num:lvl){
            avg+=num;
        }
        return avg/lvl.size();
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null) return ans;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> lvl=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node=q.peek();
                q.poll();
                lvl.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            ans.add(getAvg(lvl));
        }
        return ans;
    }
}
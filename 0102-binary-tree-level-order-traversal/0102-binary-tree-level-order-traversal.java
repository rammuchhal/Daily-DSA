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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> lvlOdrTrv
                                =new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root==null) return lvlOdrTrv;

        q.offer(root);
        int highestVal=Integer.MAX_VALUE;
        TreeNode dummy=new TreeNode(highestVal);
        q.offer(dummy);

        int level=0;
        lvlOdrTrv.add(new ArrayList<>());

        while(!q.isEmpty()){
            TreeNode temp=q.peek();
            q.poll();

            if(temp.val==highestVal){
                if(!q.isEmpty()){
                    lvlOdrTrv.add(new ArrayList<>());
                    q.offer(dummy);
                    level++;
                }
            }
            else{
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);

                lvlOdrTrv.get(level).add(temp.val);
            }

        }
        return lvlOdrTrv;
    }
}
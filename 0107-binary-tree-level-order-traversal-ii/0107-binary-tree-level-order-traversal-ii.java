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
        int level=0;
        if(root==null) return ans;

        q.offer(root);
        int minVal=Integer.MIN_VALUE;
        TreeNode dummy=new TreeNode(Integer.MIN_VALUE);
        q.offer(dummy);
        
        Stack<TreeNode> s=new Stack<>();

        while(!q.isEmpty()){
            TreeNode front=q.peek();
            q.poll();
            if(!q.isEmpty()) s.push(front);

            if(front.val==minVal){
                if(!q.isEmpty()) q.offer(dummy);
            }
            else{
                if(front.left!=null) q.offer(front.left);
                if(front.right!=null) q.offer(front.right);
            }
        }
        
        while(!s.isEmpty()){
            if(level==ans.size())
                ans.add(new ArrayList<>());
            
            while(!s.isEmpty() && s.peek().val!=minVal){
                ans.get(level).add(s.peek().val);
                s.pop();
            }
            if(!s.isEmpty()) s.pop();

            Collections.reverse(ans.get(level));
            level++;
        }
        return ans;
    }
}
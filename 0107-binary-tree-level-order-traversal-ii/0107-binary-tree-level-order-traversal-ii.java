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
        ans.add(new ArrayList<>());
        
        q.offer(root);
        int minVal=Integer.MIN_VALUE;
        TreeNode dummy=new TreeNode(Integer.MIN_VALUE);
        q.offer(dummy);

        while(!q.isEmpty()){
            TreeNode front=q.peek();
            q.poll();

            if(front.val==minVal){
                if(!q.isEmpty()){
                    ans.add(new ArrayList<>());
                    level++;
                    q.offer(dummy);
                } 
            }
            else{
                if(front.left!=null) q.offer(front.left);
                if(front.right!=null) q.offer(front.right);
                ans.get(level).add(front.val);
            }
        }
        
        // while(!s.isEmpty()){
        //     if(level==ans.size())
        //         ans.add(new ArrayList<>());
            
        //     while(!s.isEmpty() && s.peek().val!=minVal){
        //         ans.get(level).add(s.peek().val);
        //         s.pop();
        //     }
        //     if(!s.isEmpty()) s.pop();

        Collections.reverse(ans);
        //     level++;
        // }
        return ans;
    }
}
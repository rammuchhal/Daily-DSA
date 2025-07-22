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
    private void getRightView(TreeNode root,int lvl,Map<Integer,Integer> map){
        if(root==null) return;

        map.put(lvl,root.val);
        getRightView(root.left,lvl+1,map);
        getRightView(root.right,lvl+1,map);
    }
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> map=new TreeMap<>();
        getRightView(root,0,map);

        List<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
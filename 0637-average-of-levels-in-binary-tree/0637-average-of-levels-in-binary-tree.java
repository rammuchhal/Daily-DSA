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
    void inOrder(TreeNode root,List<Double> sum,List<Integer> sizes,int level){
        if(root==null) return;
        if(level==sum.size()){
            sum.add(0.00);
            sizes.add(0);
        }

        inOrder(root.left,sum,sizes,level+1);

        sum.set(level,sum.get(level)+root.val);
        sizes.set(level,sizes.get(level)+1);

        inOrder(root.right,sum,sizes,level+1);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg=new ArrayList<>();
        List<Integer> sizes=new ArrayList<>();

        inOrder(root,avg,sizes,0);

        for(int i=0;i<avg.size();i++){
            avg.set(i,avg.get(i)/sizes.get(i));
        }
        return avg;
    }
}
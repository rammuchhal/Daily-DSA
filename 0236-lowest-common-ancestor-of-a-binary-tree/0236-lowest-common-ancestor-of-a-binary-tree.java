/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean findPath(TreeNode root,TreeNode node,List<TreeNode> path){
        if(root==null) return false;

        path.add(root);
        if(root==node) return true;

        if(findPath(root.left,node,path) || findPath(root.right,node,path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1=new ArrayList<>();
        List<TreeNode> path2=new ArrayList<>();

        findPath(root,p,path1);
        findPath(root,q,path2);

        int i=0;
        while(i<path1.size() && i<path2.size()){
            if(path1.get(i)!=path2.get(i)) break;
            i++;
        }
        return path1.get(i-1);
    }
}
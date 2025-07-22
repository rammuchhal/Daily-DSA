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
class NodeLoc{
    Integer lvl;
    Integer dist;
    TreeNode curr;
    NodeLoc(Integer lvl,Integer dist,TreeNode curr){
        this.lvl=lvl;
        this.dist=dist;
        this.curr=curr;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,Map<Integer,List<Integer>>> mapV=new TreeMap<>();
        
        Queue<NodeLoc> q=new LinkedList<>();
        q.offer(new NodeLoc(0,0,root));

        while(!q.isEmpty()){
            NodeLoc front=q.poll();
            int dist=front.dist;
            int lvl=front.lvl;
            TreeNode curr=front.curr;

            List<Integer> s;
            Map<Integer,List<Integer>> mapH;
            if(!mapV.containsKey(dist)){
                s=new ArrayList<>();
                mapH=new TreeMap<>();
            }
            else{
                mapH=mapV.get(dist);
                if(!mapH.containsKey(lvl)){
                    s=new ArrayList<>();
                }
                else s=mapH.get(lvl);
            }
            s.add(curr.val);
            mapH.put(lvl,s);
            mapV.put(dist,mapH);

            if(curr.left!=null) q.offer(new NodeLoc(lvl+1,dist-1,curr.left));
            if(curr.right!=null) q.offer(new NodeLoc(lvl+1,dist+1,curr.right));
        }

        List<List<Integer>> ans=new ArrayList<>();

        for(Map.Entry<Integer,Map<Integer,List<Integer>>> entry:mapV.entrySet()){
            ArrayList<Integer> sameVNodes=new ArrayList<>();
            Map<Integer,List<Integer>> mapH=entry.getValue();

            for(Map.Entry<Integer,List<Integer>> e:mapH.entrySet()){
                List<Integer> arr=e.getValue();
                Collections.sort(arr);
                for(Integer value:arr){
                    sameVNodes.add(value);
                }
            }
            ans.add(sameVNodes);
        }
        return ans;  
    }
}
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans=new ArrayList<>();
        ans.add(folder[0]);
        int n=folder.length;

        for(int i=1;i<n;i++){
            String last=ans.get(ans.size()-1);
            String parentPre=last + "/";

            if(!folder[i].startsWith(parentPre)){
                ans.add(folder[i]);
            }
        }
        return ans;
    }
}
class Solution {
    public int[] findArray(int[] pref) {
        int val=pref[0];
        int[] ans=new int[pref.length];
        ans[0]=val;

        for(int i=1;i<pref.length;i++){
           val^=pref[i];
           ans[i]=val;
           val=pref[i];
        }
        return ans;
    }
}
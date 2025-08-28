class Solution {
    int getWays(int i,int[] dp){
        if(i<=2) return i;

        if(dp[i]!=-1) return dp[i];
        
        int oneStep=getWays(i-1,dp);
        int twoStep=getWays(i-2,dp);

        return dp[i]=oneStep+twoStep;
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);

        return getWays(n,dp);

    }
}
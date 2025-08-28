class Solution {
    int getFib(int i,int[] dp){
        if(i<=1) return i;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=getFib(i-1,dp)+getFib(i-2,dp);
    }
    public int fib(int n) {
        int[] dp =new int[n+1];
        Arrays.fill(dp,-1);

        if(n<=1) return n;
        dp[0]=0;
        dp[1]=1;
        return getFib(n,dp);
    }
}